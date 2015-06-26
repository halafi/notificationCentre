package fh.notificationCentre.rest;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NotificationCentreApplication extends Application<NotificationCentreConfiguration> {

    public static void main(String[] args) throws Exception {
        new NotificationCentreApplication().run(args);
    }

    @Override
    public String getName() {
        return "notificationCentre";
    }

    @Override
    public void initialize(Bootstrap<NotificationCentreConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets"));
    }

    @Override
    public void run(NotificationCentreConfiguration configuration, Environment environment) {
        final NotificationResource resource = new NotificationResource();
        final HtmlPageResource htmlRes = new HtmlPageResource();
        environment.jersey().register(resource);
        environment.jersey().register(htmlRes);
    }

}