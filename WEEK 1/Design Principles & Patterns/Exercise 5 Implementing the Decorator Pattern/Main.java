package decorator;

public class Main {
    public static void main(String[] args) {
        // Base Notifier (Email only)
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("=== Basic Email Notification ===");
        emailNotifier.send("System maintenance tonight at 10 PM.");

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\n=== Email + SMS Notification ===");
        emailAndSMS.send("Server is down!");

        // Email + SMS + Slack
        Notifier fullNotification = new SlackNotifierDecorator(
                                        new SMSNotifierDecorator(
                                            new EmailNotifier()));
        System.out.println("\n=== Email + SMS + Slack Notification ===");
        fullNotification.send("Critical alert: Database connection failed!");
    }
}
