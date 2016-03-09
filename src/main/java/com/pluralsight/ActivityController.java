package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityResourceStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * http://localhost:8080/webapi/activities
 */
@Path("activities")
public class ActivityController {

    private ActivityRepository activityRepository = new ActivityResourceStub();

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        activityRepository.create(activity);
        return activity;
    }


    /**
     * http://localhost:8080/webapi/activities/activity
     *
     * @param formParams
     * @return
     */
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {

        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

        activityRepository.create(activity);
        return activity;
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getIt() {
        return activityRepository.findAllActivities();
    }

    /**
     * http://localhost:8080/webapi/activities/1234
     */
    @Path("{activityId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getActivity(@PathParam("activityId") String activityId) {
        if(activityId == null || activityId.length() < 4){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Activity activity = activityRepository.findActivity(activityId);

        if(activity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(activity).build();
    }

    /**
     * http://localhost:8080/webapi/activities/1234/user
     */
    @Path("{activityId}/user")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getActivityUser(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId).getUser();
    }
}
