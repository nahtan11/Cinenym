package com.example.nathan.cinenym;

/**
 * Created by Adam Copeland on 08/04/2018.
 */

public class Movie {
    private String name;
    private String rating;
    private String overview;
    private String linkToImage;

    public Movie(String name, String rating, String overview, String linkToImage)
    {
        this.name = name;
        this.rating = rating;
        this.overview = overview;
        this.linkToImage = linkToImage;
    }
    public String getImageLink()
    {
        return linkToImage;
    }
    public String toString()
    {
        return ""+name+"\nRating:   "+rating+"\nOverview:   "+overview;
    }

    public String getLinkToImage() {
        return linkToImage;
    }
}
