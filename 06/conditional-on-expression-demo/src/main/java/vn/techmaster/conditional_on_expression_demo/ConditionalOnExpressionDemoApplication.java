package vn.techmaster.conditional_on_expression_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ConditionalOnExpressionDemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(ConditionalOnExpressionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beans = context.getBeanDefinitionNames();
		Arrays.sort(beans);

		boolean contains = Arrays.stream(beans).anyMatch("module"::equalsIgnoreCase);
		if (contains) {
			System.out.println("Module loaded");
		} else {
			System.out.println("Module not loaded");
		}
	}
}
