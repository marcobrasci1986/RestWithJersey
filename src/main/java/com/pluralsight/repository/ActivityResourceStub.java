package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaBa on 8/03/2016.
 */
public class ActivityResourceStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities(){
        ArrayList<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("'Swimming'");
        activity1.setDuration(55);

        Activity activity2 = new Activity();
        activity2.setDescription("'Cycling'");
        activity2.setDuration(120);

        activities.add(activity1);
        activities.add(activity2);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {

        if(activityId.equals("7777")){
            return null;
        }
        Activity activity1 = new Activity();
        activity1.setDescription("'Swimming'");
        activity1.setDuration(55);
        activity1.setId(activityId);

        User user = new User();
        user.setId("5678");
        user.setName("John");

        activity1.setUser(user);

        return activity1;
    }

    @Override
    public void create(Activity activity) {

    }
}
