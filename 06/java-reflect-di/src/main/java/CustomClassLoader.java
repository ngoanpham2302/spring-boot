import java.io.*;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b,0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        byte[] buffer = null;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
             ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ) {
            int nextValue = 0;
            while ((nextValue = inputStream.read()) != -1) {
                byteOutStream.write(nextValue);
            }

            buffer = byteOutStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer;
    }
}
