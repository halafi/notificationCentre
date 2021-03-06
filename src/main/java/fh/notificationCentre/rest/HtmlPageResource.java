package fh.notificationCentre.rest;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;

/**
 * You can also serve index.html from the root path with AssetBundle instead of the service.
 * Just change Dropwizard config.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HtmlPageResource {

    @GET
    public Response index() {
        String pageContent = "";
        try {
            URL clientPage = Resources.getResource("assets/index.html");
            pageContent = Resources.toString(clientPage, Charsets.UTF_8);
        } catch (IOException e) {
            return Response.serverError().build();
        }
        return Response.ok(pageContent).build();
    }
}
