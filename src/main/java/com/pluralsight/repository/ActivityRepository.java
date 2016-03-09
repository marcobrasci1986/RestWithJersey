package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.List;

/**
 * Created by MaBa on 8/03/2016.
 */
public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);

    void create(Activity activity);
}
