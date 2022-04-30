package vn.techmaster.labdidemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vn.techmaster.labdidemo.intefaces.Steering;

public class Car {
    private Engine engine;

    @Autowired
    @Qualifier("manualSteering")
    private Steering steering;

    public Car (Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", steering=" + steering + ']';
    }
}
