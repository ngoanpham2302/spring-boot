package vn.techmaster.conditional_on_property_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConditionalOnPropertyDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConditionalOnPropertyDemoApplication.class, args);
		NotificationSender notificationSender = context.getBean(NotificationSender.class);

		String message = "Hello World!";
		System.out.println("Instance: " + notificationSender);
		System.out.println(notificationSender.sendMessage(message));
	}
}
