package fh.notificationCentre.service;

import fh.notificationCentre.cache.NotificationCache;
import fh.notificationCentre.data.entities.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by filip on 26.6.15.
 */
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationCache notificationCache;

    final Logger log = LoggerFactory.getLogger(this.getClass());

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
}
