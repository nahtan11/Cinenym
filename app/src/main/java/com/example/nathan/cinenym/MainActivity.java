package com.example.nathan.cinenym;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private Button signOut;
    private String Uid;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickSearch(View view) {
        EditText search = findViewById(R.id.editText);
        String inputMovie = search.getText().toString();
        Intent startNewActivity = new Intent(this, MovieSearchActivity.class);

        if(!(inputMovie.length() == 0 || inputMovie.equals(" "))) {
            startActivity(startNewActivity);
            fetchedData process = new fetchedData(inputMovie);
            process.execute();
            Toast.makeText(MainActivity.this, inputMovie,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickWhatToWatch(View view) {
        Intent startNewActivity = new Intent(this, WhatToWatchActivity.class);
        // EditText search = (EditText) findViewById(R.id.search);
        //String message = search.getText().toString();
        startActivity(startNewActivity);
    }

    public void onClickSeenItList(View view) {
        Intent startNewActivity = new Intent(this, SeenItListActivity.class);
        // EditText search = (EditText) findViewById(R.id.search);
        //String message = search.getText().toString();
        startActivity(startNewActivity);
    }

    public void onClickProfile(View view) {
        if(Uid != null) {
            Intent startNewActivity = new Intent(this, ProfileActivity.class);
            startActivity(startNewActivity);
        }
        else{
            Intent startNewActivity = new Intent(this, LoginActivity.class);
            startActivity(startNewActivity);
        }
    }

}
