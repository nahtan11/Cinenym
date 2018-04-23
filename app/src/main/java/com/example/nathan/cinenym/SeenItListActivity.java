package com.example.nathan.cinenym;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nathan.cinenym.FirebaseLis.MovieAdapter;
import com.example.nathan.cinenym.FirebaseLis.MovieListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SeenItListActivity extends Activity implements MovieListener {
    private MovieAdapter movieAdapter;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public String inputMovie;
    private ListView moviesListview;
    private String uID = (String) mAuth.getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seen_it_list);
        movieAdapter = new MovieAdapter();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(uID);
        movieAdapter.setOnMovieReceivedListener(this);
        databaseReference.addValueEventListener(movieAdapter);

       /* DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mName = ref.child("Users").child(uID);

        mName.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                inputMovie = dataSnapshot.child("0").getValue().toString();
                //poop.set(0,inputMovie);
                //Toast.makeText(SeenItListActivity.this, inputMovie, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SeenItListActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Toast.makeText(SeenItListActivity.this, inputMovie, Toast.LENGTH_SHORT).show();
            Intent startNewActivity = new Intent(this, MovieSearchActivity.class);
            startActivity(startNewActivity);
            fetchedData process = new fetchedData(inputMovie);
            process.execute();
        }*/
    }


            public void onClickBack(View view) {
        finish();
    }


    @Override
    public void moviesReceived(final ArrayList<Movie> seenIt) {
        if(seenIt != null) {
            final ArrayList<String> movieNames = new ArrayList<>();
            moviesListview = findViewById(R.id.listviewMovies);
            //moviesListview.setPrompt("List of seen movies");
           for(Movie movie: seenIt) {
               movieNames.add(movie.getName());
               if(movie.getName().isEmpty())
                   Toast.makeText(this, "No Movies in seen it list", Toast.LENGTH_SHORT).show();
           }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, movieNames);
           arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            moviesListview.setAdapter(arrayAdapter);
        }
    }
}
