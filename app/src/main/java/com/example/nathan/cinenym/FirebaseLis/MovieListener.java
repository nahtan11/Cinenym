package com.example.nathan.cinenym.FirebaseLis;

/**
 * Created by danie on 4/22/2018.
 */
import java.util.ArrayList;

import  com.example.nathan.cinenym.Movie;

public interface MovieListener {

    void moviesReceived(ArrayList<Movie> seenIt);
}
