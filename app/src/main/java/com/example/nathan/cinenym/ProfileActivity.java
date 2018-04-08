package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void onClickTest(View view) {
        Intent startNewActivity = new Intent(this, LoginActivity.class);
        // EditText search = (EditText) findViewById(R.id.search);
        //String message = search.getText().toString();
        startActivity(startNewActivity);
    }

    public void onClickBack(View view) {
        finish();
    }
    
}
