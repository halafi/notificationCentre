package fh.notificationCentre.service;

import fh.notificationCentre.cache.NotificationCache;
import fh.notificationCentre.cache.NotificationMapCache;
import fh.notificationCentre.data.entities.Notification;

import java.util.List;
import java.util.Map;

/**
 * Created by filip on 26.6.15.
 */
public class NotificationServiceImpl implements NotificationService {

    private NotificationCache notificationCache = NotificationMapCache.getInstance();

    //Singleton
    private static NotificationServiceImpl instance = new NotificationServiceImpl();

    private NotificationServiceImpl() {
        notificationCache.init();
    }

    public static synchronized NotificationServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void markNotificationAsRead(Notification notification, String userGuid) {
        Map<String, Boolean> readByUserGuid = notification.getReadByUserGuid();
        readByUserGuid.put(userGuid, true);
        notificationCache.put(notification);
    }

    @Override
    public void deleteNotification(Notification notification) {
        notificationCache.remove(notification);
    }

    @Override
    public List<Notification> getRecentNotifications() {
        return notificationCache.getAll(); // TBD
    }

    @Override
    public Notification getNotification(String notificationGuid) {
        return notificationCache.get(notificationGuid);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationCache.getAll();
    }
}
