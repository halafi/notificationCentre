package fh.notificationCentre.cache;

import fh.notificationCentre.data.entities.Notification;
import fh.notificationCentre.data.parser.NotificationParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by filip on 26.6.15.
 */
public class NotificationMapCache implements NotificationCache {

    @Autowired
    private NotificationParser parser;

    final Logger log = LoggerFactory.getLogger(this.getClass());

    private Map<String, Notification> notificationsByGuid;


    @Override
    public void init() {
        this.notificationsByGuid = new HashMap<>();
        // load in xlsx data
        final List<Notification> notifications = parser.parse("src/main/resources/notifications.xlsx");
        for (Notification n : notifications) {
            put(n);
        }
    }

    @Override
    public void clear() {
        this.notificationsByGuid.clear();
    }

    @Override
    public void put(Notification notification) {
        this.notificationsByGuid.put(notification.getNotificationGuid(), notification);
    }

    @Override
    public void remove(Notification notification) {
        this.notificationsByGuid.remove(notification.getNotificationGuid());
    }

    @Override
    public Notification get(String guid) {
        if (this.notificationsByGuid.containsKey(guid)) {
            return this.notificationsByGuid.get(guid);
        }
        return null;
    }
}
