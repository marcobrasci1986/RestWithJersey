package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityResourceStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * http://localhost:8080/webapi/activities
 */
@Path("activities")
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityResourceStub();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Activity> getIt() {
        return activityRepository.findAllActivities();
    }
}
