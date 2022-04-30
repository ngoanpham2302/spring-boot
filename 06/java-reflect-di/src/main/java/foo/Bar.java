package foo;

public class Bar implements Swim {
    @Override
    public void swim() {
        System.out.println("... swim in ocean");
    }

    public void doSomething() {
        System.out.println("...program java");
    }

    public void saySomething() {
        System.out.println("...hello");
    }
}
