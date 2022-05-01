package vn.techmaster.conditional_on_property_demo;

public class SMSNotification implements NotificationSender{
    @Override
    public String sendMessage(String message) {
        return "SMS Notification: " + message;
    }
}
