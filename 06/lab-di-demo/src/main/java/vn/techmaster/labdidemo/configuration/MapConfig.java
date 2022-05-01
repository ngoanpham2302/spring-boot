package vn.techmaster.labdidemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import vn.techmaster.labdidemo.bean.StreetMap;

@Configuration
public class MapConfig {
    @Bean
    @Scope("prototype")
    public StreetMap streetmap() {
        return new StreetMap();
    }
}
