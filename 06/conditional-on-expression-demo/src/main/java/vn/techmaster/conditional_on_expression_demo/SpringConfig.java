package vn.techmaster.conditional_on_expression_demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    @ConditionalOnExpression(value = "${module.enabled:true} and ${module.submodule.enabled:true}")
    public Module module() {
        return new Module();
    }
}
