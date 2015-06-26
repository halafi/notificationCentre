package fh.notificationCentre.rest;

import fh.notificationCentre.cache.NotificationCache;
import fh.notificationCentre.cache.NotificationMapCache;
import fh.notificationCentre.data.entities.Notification;
import fh.notificationCentre.service.NotificationService;
import fh.notificationCentre.service.NotificationServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
@Path("/notification")
@Produces(MediaType.APPLICATION_JSON)
public class NotificationResource {

    //private NotificationCache notificationCache = NotificationMapCache.getInstance();
    private NotificationService notificationService = NotificationServiceImpl.getInstance();

    public NotificationResource() {
        //this.notificationCache.init();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
    /*public Notification getTest(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }*/
}
