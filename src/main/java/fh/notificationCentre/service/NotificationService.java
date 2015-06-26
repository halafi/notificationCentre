package fh.notificationCentre.service;

import fh.notificationCentre.data.entities.Notification;

import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
public interface NotificationService {
    public void markNotificationAsRead(Notification notification, String userGuid);
    public void deleteNotification(Notification notification);
    public void getRecentNotifications();
    public void getNotification(String notificationGuid);
    public List<Notification> getAllNotifications();
}
