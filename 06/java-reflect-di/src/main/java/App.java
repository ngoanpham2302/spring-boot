import components.Emailer;
import foo.Bar;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        inspectFooBar();
        System.out.println("---------------");
        demoComponentScan();
    }

    private static void inspectFooBar() {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Object obj = customClassLoader.findClass("foo.Bar").getDeclaredConstructor().newInstance();
            Class<?> objClass = obj.getClass();
            // Class<?> objClass = Class.forName("foo.Bar");   // C2: tạo ra đối tượng kiểu Class
            // Bar obj = (Bar) objClass.getDeclaredConstructor().newInstance();

            Method[] methods = objClass.getDeclaredMethods(); // Lấy ra danh sách các method của class
            Class<?>[] interfaces = objClass.getInterfaces();

            System.out.println(String.format("\nMethod of %s class: ", objClass.getName()));
            for (Method method : methods) {
                System.out.println(method.getName());
                method.invoke(obj, null);   // Thực thi method của đối tượng obj với các tham số args
                System.out.println();
            }

            System.out.println("Interfaces of class " + objClass.getName() + ":");
            for (Class<?> i : interfaces) {
                System.out.println(i.getName());
            }

            // Lấy annotations:
            // Class<?> aClazz = Class.forName("components.Emailer");
            Class<Emailer> aClazz = Emailer.class;
            Annotation[] annotations = aClazz.getAnnotations();
            System.out.println("\nAnnotations of class " + aClazz.getSimpleName() + ":");
            for (Annotation a : annotations) {
                System.out.println(a.annotationType());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demoComponentScan() {
        System.out.println("@Component: ");
        ClasspathInspector.componentScan().forEach(e -> System.out.println(e.getName()));
    }
}
