package fh.notificationCentre.data;

import fh.notificationCentre.data.entities.Notification;
import fh.notificationCentre.data.parser.NotificationParser;
import fh.notificationCentre.data.parser.NotificationParserXLSX;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        NotificationParser parser = new NotificationParserXLSX();
        final List<Notification> notifications = parser.parse();

    }
}
