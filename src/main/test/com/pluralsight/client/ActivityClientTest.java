package com.pluralsight.client;

import com.pluralsight.model.Activity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MaBa on 9/03/2016.
 */
public class ActivityClientTest {
    private ActivityClient client;

    @Before
    public void setUp() throws Exception {
        client = new ActivityClient();
    }

    @Test
    public void testCreate() throws Exception {
        Activity activity = new Activity();
        activity.setDescription("Swimming");
        activity.setDuration(90);

        activity = client.create(activity);
        assertNotNull(activity);

    }

    @Test
    public void testGet() throws Exception {
        Activity activity = client.get("1234");

        System.out.println(activity);

        assertNotNull(activity);
    }

    @Test
    public void testGetList() throws Exception {

        List<Activity> activities = client.get();

        assertNotNull(activities);
        assertEquals(2, activities.size());
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() throws Exception {
        client.get("123");
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound() throws Exception {
        client.get("7777");
    }
}