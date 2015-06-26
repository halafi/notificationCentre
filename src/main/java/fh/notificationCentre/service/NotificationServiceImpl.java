package fh.notificationCentre.service;

import fh.notificationCentre.cache.NotificationCache;
import fh.notificationCentre.cache.NotificationMapCache;
import fh.notificationCentre.data.entities.Notification;

import java.util.List;

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

    }

    @Override
    public void deleteNotification(Notification notification) {

    }

    @Override
    public void getRecentNotifications() {

    }

    @Override
    public void getNotification(String notificationGuid) {

    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationCache.getAll();
    }
}
