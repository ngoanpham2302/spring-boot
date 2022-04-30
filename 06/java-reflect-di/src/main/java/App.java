import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        demoComponentScan();
        inspectFooBar();
    }

    private static void inspectFooBar() {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Object obj = customClassLoader.findClass("foo.Bar").getDeclaredConstructor().newInstance();
            Class<?> objClass = obj.getClass();
            Method[] methods = objClass.getDeclaredMethods();
            Class<?>[] interfaces = objClass.getInterfaces();
            System.out.println(String.format("Method of %s class", obj.getClass().getName()));

            for (Method method: methods) {
                System.out.println(method.getName());
                method.invoke(obj, null);
            }

            for (Class<?> i : interfaces) {
                System.out.println(i.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demoComponentScan() {
        ClasspathInspector.componentScan().forEach(e -> System.out.println(e.getName()));
    }
}
