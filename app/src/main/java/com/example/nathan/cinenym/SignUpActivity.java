package com.example.nathan.cinenym;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends Activity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextUsername;
    private Button buttonRegister;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        buttonRegister = findViewById(R.id.email_sign_in_button);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextUsername = findViewById(R.id.username);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                //if(view == textViewSignin)
                //Open main activity aka Cinenym
            }
        });
    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email left blank
            Toast.makeText(this, "Enter a Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(username)) {
            // email left blank
            Toast.makeText(this, "Enter a Username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            // password left blank
            Toast.makeText(this, "Enter a Password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            String uID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            if(uID != null) {
                                DatabaseReference data = FirebaseDatabase.getInstance().getReference("Users").child(uID).child(username);
                                data.push();
                                User user = new User(username, "");
                                data.setValue(user);
                            }
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "Failed to Register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        progressDialog.dismiss();
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }





    public void onClickBack(View view) {
        finish();
    }
}
