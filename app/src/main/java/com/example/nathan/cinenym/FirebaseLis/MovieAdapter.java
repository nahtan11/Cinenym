package com.example.nathan.cinenym.FirebaseLis;

/**
 * Created by danie on 4/22/2018.
 */
import android.content.Context;

import com.example.nathan.cinenym.Movie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MovieAdapter implements ValueEventListener {

    private MovieListener movieListener;
    private String uID;
    private Context context;
    private static final String noMovieMessage = "You have no movie registered from your user as of yet!";

    public MovieAdapter(String uID, Context context) {
        this.uID = uID;
        this.context = context;

    }

    public MovieAdapter() {
    }


    public void setOnMovieReceivedListener(MovieListener movieListener) {
        this.movieListener = movieListener;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        if (movieListener != null) {
            ArrayList<Movie> seenIt = new ArrayList<>();
            seenIt.clear();
            for (DataSnapshot dChild : dataSnapshot.getChildren()) {
                Movie movie = dChild.getValue(Movie.class);
                seenIt.add(movie);
            }

            movieListener.moviesReceived(seenIt);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}



