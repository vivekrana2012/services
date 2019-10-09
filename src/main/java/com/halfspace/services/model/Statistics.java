package com.halfspace.services.model;

import java.io.Serializable;

public class Statistics implements Serializable {

    private int views;

    public Statistics(int views) {
        this.views = views;
    }

    public Statistics() {}

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
