package fh.notificationCentre.cache;

import fh.notificationCentre.data.entities.Notification;
import fh.notificationCentre.data.parser.NotificationParser;
import fh.notificationCentre.data.parser.NotificationParserXLSX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by filip on 26.6.15.
 */
public class NotificationMapCache implements NotificationCache {
    //storage
    private Map<String, Notification> notificationsByGuid;

    private NotificationParser parser = NotificationParserXLSX.getInstance();

    //Singleton
    private static NotificationMapCache instance = new NotificationMapCache();

    private NotificationMapCache() {
    }

    public static synchronized NotificationMapCache getInstance() {
        return instance;
    }

    @Override
    public void init() {
        this.notificationsByGuid = new HashMap<>();
        // load in xlsx data at start
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

    @Override
    public List<Notification> getAll() {
        return new ArrayList<>(this.notificationsByGuid.values());
    }

    public void setParser(NotificationParser parser) {
        this.parser = parser;
    }
}
