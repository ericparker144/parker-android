package com.engineeringeric.parkerapp;

import android.app.Application;

/**
 * Created by Eric on 3/16/2017.
 */
public class Globals extends Application {

    private String userId;
    private String firstName;
    private String lastName;

    public String getUserId() {
        return this.userId;
    }
    public void setUserId (String userId) {
        this.userId = userId;
    }
    public String getFirstName () {
        return this.firstName;
    }
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
