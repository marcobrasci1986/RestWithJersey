package com.pluralsight.repository;

import com.pluralsight.model.Activity;

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
}
