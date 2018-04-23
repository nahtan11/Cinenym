package com.example.nathan.cinenym;

/**
 * Created by Adam Copeland on 08/04/2018.
 */

public class Movie {
    private String name;
    private String rating;
    private String overview;
    private String linkToImage;

    public Movie() {

    }

    public Movie(String name, String rating, String overview, String linkToImage)
    {
        this.name = name;
        this.rating = rating;
        this.overview = overview;
        this.linkToImage = linkToImage;
    }

    public Movie(String name) {
        this.name = name;
    }

    public String getOverview() {

        return overview;
    }

    public String getRating() {
        return rating;

    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setLinkToImage(String linkToImage) {
        this.linkToImage = linkToImage;
    }


    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public String toString()
    {
        return ""+name+"\nRating:   "+rating+"\nOverview:   "+overview;
    }

}
