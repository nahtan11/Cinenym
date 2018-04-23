package com.example.nathan.cinenym.FirebaseLis;

/**
 * Created by danie on 4/22/2018.
 */

import com.example.nathan.cinenym.User;

import java.util.ArrayList;

public interface UserListener {

    void usersReceived(ArrayList<User> users);
}
