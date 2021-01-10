package io.yash.moviecatalogservice.model;

public class Movie {

    private String movieID;
    private String name;
    private String movieDiscription;

    public Movie(){

    }

    public Movie(String movieID, String name, String movieDiscription) {
        this.movieID = movieID;
        this.name = name;
        this.movieDiscription = movieDiscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieDiscription() {
        return movieDiscription;
    }

    public void setMovieDiscription(String movieDiscription) {
        this.movieDiscription = movieDiscription;
    }
}
