package vn.techmaster.labdidemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.labdidemo.bean.Engine;

@Configuration
public class EngineConfig {
    @Bean
    public Engine gasEngine() {
        return new Engine("Gas Engine");
    }

    @Bean("electricEngine")
    public Engine teslaEngine() {
        return new Engine("Tesla Electric Engine");
    }

    @Bean
    public Engine hybridEngine() {
        return new Engine("Hybrid Engine");
    }
}
