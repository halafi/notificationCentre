package fh.notificationCentre;

import fh.notificationCentre.cache.NotificationCache;
import fh.notificationCentre.service.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by filip on 26.6.15.
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        NotificationCache cache = (NotificationCache) ctx.getBean("notificationCache");
        NotificationService service = (NotificationService) ctx.getBean("notificationService");
    }
}
