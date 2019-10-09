package com.halfspace.services.model;

import java.io.Serializable;

public class StarRating implements Serializable {

    private int count;
    private float average;
    private int min;
    private int max;

    public StarRating(int count, float average, int min, int max) {
        this.count = count;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public StarRating() {}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
