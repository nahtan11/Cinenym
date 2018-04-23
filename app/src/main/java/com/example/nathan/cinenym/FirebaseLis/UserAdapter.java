package com.example.nathan.cinenym.FirebaseLis;

import android.content.Context;

import com.example.nathan.cinenym.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserAdapter implements ValueEventListener {

    private UserListener userListener;
    private String username;
    private String bio;
    private Context context;

    public UserAdapter(String username,String bio, Context context) {
        this.username = username;
        this.bio = bio;
        this.context = context;

    }

    public UserAdapter() {
    }


    public void setOnUsersReceivedListener(UserListener userListener) {
        this.userListener = userListener;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        if (userListener != null) {
            ArrayList<User> users = new ArrayList<>();
            users.clear();
            for (DataSnapshot dChild : dataSnapshot.getChildren()) {
                User user = dChild.getValue(User.class);
                users.add(user);
            }

            userListener.usersReceived(users);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}