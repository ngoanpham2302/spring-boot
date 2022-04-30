package vn.techmaster.labdidemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import vn.techmaster.labdidemo.bean.Car;
import vn.techmaster.labdidemo.bean.Engine;

@Configuration
public class CarConfig {
    @Autowired
    ApplicationContext context;

//    @Value("${engineType}")
//    private String engineType;

    @Value("#{${engineTypeMap}.keyE}")
    private String engineType;

    @Bean
    @Primary
    public Car car() {
        Engine engine;

        switch (engineType) {
            case "electric":
                engine = (Engine) context.getBean("electricEngine");
                break;
            case "hybrid":
                engine = (Engine) context.getBean("hybridEngine");
                break;
            default:
                engine = (Engine) context.getBean("gasEngine");
        }

        return new Car(engine);
    }

    @Bean
    public Car funCar() {
        return new Car((Engine) context.getBean("hybridEngine"));
    }
}
