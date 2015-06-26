package fh.notificationCentre.data.parser;

import fh.notificationCentre.data.entities.Notification;

import java.util.Collection;
import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
public interface NotificationParser {
    public List<Notification> parse();
}
