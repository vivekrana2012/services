package com.halfspace.services.model;

import java.io.Serializable;

public class Community implements Serializable {

    private StarRating starRating;
    private Statistics statistics;

    public Community(StarRating starRating, Statistics statistics) {
        this.starRating = starRating;
        this.statistics = statistics;
    }

    public Community() {}

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
