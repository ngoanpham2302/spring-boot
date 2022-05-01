package vn.techmaster.labdidemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import vn.techmaster.labdidemo.intefaces.Steering;

public class Car {
    private Engine engine;

    @Autowired
    @Qualifier("manualSteering")
    private Steering steering;

    @Autowired
    @Lazy
    private StreetMap streetMap;

    public Car (Engine engine) {
        this.engine = engine;
    }

    // Trả về điểm bắt đầu và kết thúc trong hành trình
    public String navigate() {
        return this.streetMap.getRoute();
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", steering=" + steering + ']';
    }
}
