package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends Activity {

    private Button signOut;
    private String Uid;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Button signOut = findViewById(R.id.signOut1);
        mAuth = mAuth.getInstance();
        Intent intent = getIntent();
        Uid = intent.getStringExtra("ID");
        if(Uid != null)
            signOut.setVisibility(View.VISIBLE);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                signOut.setVisibility(View.INVISIBLE);
                Toast.makeText(ProfileActivity.this, "Successfully Logged Out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    public void onClickBack(View view) {
        finish();
    }
    
}
