package com.driver;

public class Movie {

     private String name;
     private int durationInMinutes;
     private double imdbRatings;

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String name, int durationInMinutes, double imdbRatings){
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRatings = imdbRatings;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setImdbRatings(double imdbRatings) {
        this.imdbRatings = imdbRatings;
    }

    public String getName() {
        return name;
    }

    public double getImdbRatings() {
        return imdbRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
