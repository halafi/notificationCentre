package fh.notificationCentre.rest;

import fh.notificationCentre.data.entities.Notification;
import fh.notificationCentre.service.NotificationService;
import fh.notificationCentre.service.NotificationServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
@Path("/notification")
@Produces(MediaType.APPLICATION_JSON)
public class NotificationResource {

    private NotificationService notificationService = NotificationServiceImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Notification getNotification(@PathParam("id") String id) {
        return notificationService.getNotification(id);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNotification(@PathParam("id") String id) {
        Notification notification = notificationService.getNotification(id);
        if (notification != null) {
            notificationService.deleteNotification(notification);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

}
