package vn.techmaster.labdidemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.labdidemo.bean.AutoSteering;
import vn.techmaster.labdidemo.bean.ManualSteering;

@Configuration
public class SteeringConfig {
    @Bean
    public AutoSteering autoSteering() {
        return new AutoSteering();
    }

    @Bean
    public ManualSteering manualSteering() {
        return new ManualSteering();
    }
}
