package com.example.nathan.cinenym;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nathan.cinenym.FirebaseLis.UserAdapter;
import com.example.nathan.cinenym.FirebaseLis.UserListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ProfileActivity extends Activity implements UserListener {

    private Button signOut;
    private String Uid;
    private FirebaseAuth mAuth;
    private static int RESULT_LOAD_IMAGE = 1;
    static TextView userN;
    private TextView usernameField;
    private EditText bioField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final Button editBio = findViewById(R.id.button2);
        editBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                if(uID != null) {
                    DatabaseReference data = FirebaseDatabase.getInstance().getReference("Users").child(uID).child((String) usernameField.getText());
                    data.push();
                    User user = new User((String) usernameField.getText(), bioField.getText().toString());
                    data.setValue(user);
                    Toast.makeText(ProfileActivity.this, "Bio Saved.", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
        UserAdapter userAdapter = new UserAdapter();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(Uid);
        userAdapter.setOnUsersReceivedListener(this);
        databaseReference.addValueEventListener(userAdapter);
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

    @Override
    public void usersReceived(ArrayList<User> users) {
        if(users != null) {
            usernameField = (TextView) findViewById(R.id.usernameField);
            bioField = (EditText) findViewById(R.id.bioField);
            //moviesListview.setPrompt("List of seen movies");
                usernameField.setText(users.get(0).getUsername());
                bioField.setText(users.get(0).getBio());
        }
    }
}
