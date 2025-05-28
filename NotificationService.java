package studycompanion.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String message, String time) {
        // Stub: Hook for scheduled tasks or push notification integration
        System.out.println("Notification at " + time + ": " + message);
    }
}
