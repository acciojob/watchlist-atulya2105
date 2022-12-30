package com.driver;

public class Director {

    private String name;
    private int numberOfMovies;
    private double imdbRatings;

    public  Director(String name, int numberOfMovies, double imdbRatings){
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRatings = imdbRatings;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public void setImdbRatings(double imdbRatings) {
        this.imdbRatings = imdbRatings;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public double getImdbRatings() {
        return imdbRatings;
    }
}
