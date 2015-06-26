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
    public static String DATA_SOURCE = "src/main/resources/notifications.xlsx";
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
        for (Notification notification : parser.parse(DATA_SOURCE)) {
            put(notification);
        }
    }

    @Override
    public void clear() {
        notificationsByGuid.clear();
    }

    @Override
    public void put(Notification notification) {
        if (notificationsByGuid.containsKey(notification.getNotificationGuid())) { // update
            notificationsByGuid.remove(notification.getNotificationGuid());
        }
        notificationsByGuid.put(notification.getNotificationGuid(), notification); // add
    }

    @Override
    public void remove(Notification notification) {
        notificationsByGuid.remove(notification.getNotificationGuid());
    }

    @Override
    public Notification get(String guid) {
        if (notificationsByGuid.containsKey(guid)) {
            return notificationsByGuid.get(guid);
        }
        return null;
    }

    @Override
    public List<Notification> getAll() {
        return new ArrayList<>(notificationsByGuid.values());
    }

    public void setParser(NotificationParser parser) {
        this.parser = parser;
    }
}
