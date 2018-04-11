package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RandomMovie extends Activity {

    public static TextView dataR;
    public static ImageView imR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_movie);

        dataR = findViewById(R.id.fetchedG);
        imR = (ImageView) findViewById(R.id.imV);
    }


    public void onClickBack(View view) {
        finish();
    }
}
