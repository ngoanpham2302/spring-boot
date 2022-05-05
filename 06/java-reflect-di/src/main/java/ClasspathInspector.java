import annotation.Component;
import foo.Swim;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * Find classes in the classpaths (read JARs and classpath folders)
 */

public class ClasspathInspector {
    static boolean DEBUG = false;

    public static List<Class<?>> getAllKnownClasses() {
        List<Class<?>> classFiles = new ArrayList<>();
        List<File> classLocations = getClassLocationsForCurrentClasspath();
        // classLocations.stream().map(file -> getClassesFromPath(file)).collect(Collectors.toList());
        for (File file : classLocations) {
            classFiles.addAll(getClassesFromPath(file));
        }

        return classFiles;
    }

    private static List<File> getClassLocationsForCurrentClasspath() {
        List<File> urls = new ArrayList<>();
        String javaClasspath = System.getProperty("java.class.path");
        if (javaClasspath != null) {
            for (String path : javaClasspath.split(File.pathSeparator)) {
                urls.add(new File(path));
            }
        }

        return urls;
    }

    private static Collection<? extends Class<?>> getClassesFromPath(File path) {
        return path.isDirectory() ? getClassesFromDirectory(path) : getClassesFromJarFile(path);
    }

    private static Collection<? extends Class<?>> getClassesFromJarFile(File path) {
        List<Class<?>> classes = new ArrayList<>();
        log("getClassesFromJarFile: Getting class for " + path);

        try {
            if (path.canRead()) {
                try (JarFile jar = new JarFile(path)) {
                    Enumeration<JarEntry> entries = jar.entries();

                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        if (entry.getName().endsWith("class")) {
                            String className = fromFileToClassname(entry.getName());
                            log("\t getClassesFromJarFile : found " + className);
                            Class<?> claz = Class.forName(className);
                            classes.add(claz);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Fail to read classes from JAR file " + path, e);
        }
        return classes;
    }

    private static String fromFileToClassname(String fileName) {
        return fileName.substring(0, fileName.length() - 6).replaceAll("/|\\\\", "\\.");
        // return fileName.substring(0, fileName.length() - 6).replaceAll("[/\\\\]", "\\.");
    }

    private static Collection<? extends Class<?>> getClassesFromDirectory(File path) {
        List<Class<?>> classes = new ArrayList<>();
        // DEBUG = true;
        log("\t getClassesFromDirectory : get classes for " + path);

        // Get jar files from top-level directory
        List<File> jarFiles = listFiles(path, (dir, name) -> name.endsWith(".jar"), false);
        /*
         List<File> jarFiles = listFiles(path, new FilenameFilter() {
             @Override
             public boolean accept(File dir, String name) {
                 return name.endsWith(".jar");
             }
         }, false); */

        for (File file : jarFiles) {
            classes.addAll(getClassesFromJarFile(path));
        }

        // get all class-files
        List<File> classFiles = listFiles(path, (dir, name) -> name.endsWith(".class"), true);
        /* List<File> classFiles = listFiles(path, new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        }, true); */

        int subStringBeginIndex = path.getAbsolutePath().length() + 1;

        for (File classFile : classFiles) {
            String className = fromFileToClassname(classFile.getAbsolutePath().substring(subStringBeginIndex));
            log("Found class %s in path %s", className, path);
            try {
                classes.add(Class.forName(className));
            } catch (Throwable e) {
                log("Could not create class %s. %s", className, e);
            }
        }

        return classes;
    }

    private static List<File> listFiles(File directory, FilenameFilter filenameFilter, boolean recursive) {
        List<File> files = new ArrayList<>();
        File[] entries = directory.listFiles();
        for (File entry : entries) {
            // no filter or the filter accepts the file/directory, add it to the list
            if (filenameFilter == null || filenameFilter.accept(directory, entry.getName())) {
                files.add(entry);
            }

            if (recursive && entry.isDirectory()) {
                files.addAll(listFiles(entry, filenameFilter, recursive));
            }
        }
        return files;
    }

    public static List<Class<?>> getMatchingClasses(Class<?> interfaceOrSuperClass) {
        List<Class<?>> classes = getAllKnownClasses();
        log("checking %s classes", classes.size());
        return classes.stream()
                .filter(clazz -> interfaceOrSuperClass.isAssignableFrom(clazz))
                .collect(Collectors.toList());
    }

    private static void log(String pattern, final Object... args) {
        if (DEBUG) {
            System.out.printf(pattern + "\n", args);
        }
    }

    public static List<Class<?>> componentScan() {
        List<Class<?>> classes = getAllKnownClasses();
        return classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Component.class))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // find all classes in classpath
        List<Class<?>> allClasses = ClasspathInspector.getAllKnownClasses();
        System.out.printf("There are %s class available in the classpath:\n", allClasses.size());
        allClasses.forEach(claz -> System.out.println(claz.getName()));
        System.out.println();

        // find all classes that implement/subclass an interface/superclass
        // List<Class<?>> serializableClasses = ClasspathInspector.getMatchingClasses(Serializable.class);
        // serializableClasses.forEach(e -> System.out.printf("%s is Serializable\n", e));

        List<Class<?>> swimableClasses = ClasspathInspector.getMatchingClasses(Swim.class);
        swimableClasses.forEach(e -> System.out.printf("%s is Serializable\n", e));
    }
}
