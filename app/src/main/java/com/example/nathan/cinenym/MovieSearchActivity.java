package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MovieSearchActivity extends Activity {

    static TextView data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12,data13,data14,data15,data16,data17,data18,data19,data20;
    static ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13,im14,im15,im16,im17,im18,im19,im20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);
            data1 = (TextView) findViewById(R.id.fetchedD0);
            im1 = (ImageView) findViewById(R.id.movieWTW0);
            data2 = (TextView) findViewById(R.id.fetchedD1);
            im2 = (ImageView) findViewById(R.id.movieWTW1);
            data3 = (TextView) findViewById(R.id.fetchedD2);
            im3 = (ImageView) findViewById(R.id.movieWTW2);
            data4 = (TextView) findViewById(R.id.fetchedD3);
            im4 = (ImageView) findViewById(R.id.movieWTW3);
            data5 = (TextView) findViewById(R.id.fetchedD4);
            im5 = (ImageView) findViewById(R.id.movieWTW4);
            data6 = (TextView) findViewById(R.id.fetchedD5);
            im6 = (ImageView) findViewById(R.id.movieWTW5);
            data7 = (TextView) findViewById(R.id.fetchedD6);
            im7 = (ImageView) findViewById(R.id.movieWTW6);
            data8 = (TextView) findViewById(R.id.fetchedD7);
            im8 = (ImageView) findViewById(R.id.movieWTW7);
            data9 = (TextView) findViewById(R.id.fetchedD8);
            im9 = (ImageView) findViewById(R.id.movieWTW8);
            data10 = (TextView) findViewById(R.id.fetchedD9);
            im10 = (ImageView) findViewById(R.id.movieWTW9);
            data11 = (TextView) findViewById(R.id.fetchedD10);
            im11 = (ImageView) findViewById(R.id.movieWTW10);
            data12 = (TextView) findViewById(R.id.fetchedD11);
            im12 = (ImageView) findViewById(R.id.movieWTW11);
            data13 = (TextView) findViewById(R.id.fetchedD12);
            im13 = (ImageView) findViewById(R.id.movieWTW12);
            data14 = (TextView) findViewById(R.id.fetchedD13);
            im14 = (ImageView) findViewById(R.id.movieWTW13);
            data15 = (TextView) findViewById(R.id.fetchedD14);
            im15 = (ImageView) findViewById(R.id.movieWTW14);
            data16 = (TextView) findViewById(R.id.fetchedD15);
            im16 = (ImageView) findViewById(R.id.movieWTW15);
            data17 = (TextView) findViewById(R.id.fetchedD16);
            im17 = (ImageView) findViewById(R.id.movieWTW16);
            data18 = (TextView) findViewById(R.id.fetchedD17);
            im18 = (ImageView) findViewById(R.id.movieWTW17);
            data19 = (TextView) findViewById(R.id.fetchedD18);
            im19 = (ImageView) findViewById(R.id.movieWTW18);
            data20 = (TextView) findViewById(R.id.fetchedD19);
            im20= (ImageView) findViewById(R.id.movieWTW19);

    }



    public void onClickBack(View view) {
        finish();
    }
}
