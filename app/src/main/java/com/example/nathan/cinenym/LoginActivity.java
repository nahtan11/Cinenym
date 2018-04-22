package com.example.nathan.cinenym;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class LoginActivity extends Activity  {

    private EditText editTextPassword;
    private EditText editTextEmail;
    private Button buttonSignin;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart(){
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            finish();
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("ID",mAuth.getCurrentUser().getUid());
            Toast.makeText(LoginActivity.this, mAuth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        progressBar = new ProgressBar(this);
        editTextPassword = findViewById(R.id.password);
        editTextEmail = findViewById(R.id.email);
        buttonSignin = findViewById(R.id.email_sign_in_button);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void login() {
        String password = editTextPassword.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email left blank
            Toast.makeText(this, "Enter a Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            // password left blank
            Toast.makeText(this, "Enter a Password", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) { //User in the database
                            finish();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            /*If set, and the activity being launched is already running in the
                            current task, then instead of launching a new instance of that activity,
                            all of the other activities on top of it will be closed and this Intent
                            will be delivered to the (now on top) old activity as a new Intent.*/

                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //clears activities at top of stack
                            //if they press back at Welcome screen, it will not come back here
                            i.putExtra("ID", mAuth.getCurrentUser().getUid());
                            startActivity(i);

                        } else
                            showToast(task.getException().getMessage());
                    }
                }
        );
    }

    public void OnClickSignUp(View view) {
        Intent startNewActivity = new Intent(this, SignUpActivity.class);
        startActivity(startNewActivity);
    }



    public void onClickBack(View view) {
        finish();
    }

}

