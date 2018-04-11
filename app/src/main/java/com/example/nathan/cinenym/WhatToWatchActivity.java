package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WhatToWatchActivity extends Activity {

    public static TextView data1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_watch);
    }

    public void OnClickAction(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "28";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickAdventure(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "12";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickAnimation(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "16";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickComedy(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "35";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickDocumentary(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "99";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickDrama(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "18";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickFamily(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "10751";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }

    public void OnClickHorror(View view) {
        Intent startNewActivity = new Intent(this, RandomMovie.class);
        String inputGenre = "27";
        FetchGenre input = new FetchGenre(inputGenre);
        input.execute();
        Toast.makeText(WhatToWatchActivity.this, inputGenre,
                Toast.LENGTH_SHORT).show();
        startActivity(startNewActivity);
    }
    public void onClickBack(View view) {
        finish();
    }
}
