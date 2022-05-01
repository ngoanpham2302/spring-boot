package vn.techmaster.conditional_on_property_demo;

public class EmailNotification implements NotificationSender {
    @Override
    public String sendMessage(String message) {
        return "Email Notification: " + message;
    }
}
