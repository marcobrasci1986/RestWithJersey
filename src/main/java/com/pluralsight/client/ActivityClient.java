package com.pluralsight.client;

import com.pluralsight.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by MaBa on 9/03/2016.
 */
public class ActivityClient {

    private Client client;
    private WebTarget target;

    public ActivityClient() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/webapi/");
    }

    /**
     * http://localhost:8080/webapi/activities/1234
     *
     * @param id
     * @return
     */
    public Activity get(String id) {

        Response response = target.path("activities/" + id)
                .request(MediaType.APPLICATION_JSON).get(Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " : error on server");
        }

        return response.readEntity(Activity.class);
    }

    public List<Activity> get() {
        List<Activity> response = target.path("activities/")
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
                });
        return response;
    }

    public Activity create(Activity activity) {
        Response response = target.path("activities/activity")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(activity, MediaType.APPLICATION_JSON));

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " : error on server");
        }
        return response.readEntity(Activity.class);
    }
}
