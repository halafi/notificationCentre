package fh.notificationCentre.cache;

import fh.notificationCentre.data.entities.Notification;

import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
public interface NotificationCache {
    public void init();
    public void put(Notification notification);
    public void remove(Notification notification);
    public void clear();
    public Notification get(String guid);
    public List<Notification> getAll();
}
