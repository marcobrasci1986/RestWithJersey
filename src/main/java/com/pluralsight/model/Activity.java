package com.pluralsight.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MaBa on 8/03/2016.
 */
@XmlRootElement
public class Activity {
    private String description;
    private int duration;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
