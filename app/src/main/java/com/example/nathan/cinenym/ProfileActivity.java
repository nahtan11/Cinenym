package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends Activity {

    private Button signOut;
    private String Uid;
    private FirebaseAuth mAuth;
    private static int RESULT_LOAD_IMAGE = 1;
    static TextView userN;
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

    public void OnClickProfilePic(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            ImageView imageView = (ImageView) findViewById(R.id.imageButton2);
            imageView.setImageURI(selectedImage);


        }


    }



    public void onClickBack(View view) {
        finish();
    }
    
}
