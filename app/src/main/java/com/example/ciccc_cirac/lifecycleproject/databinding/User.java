package com.example.ciccc_cirac.lifecycleproject.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.ciccc_cirac.lifecycleproject.BR;

/**
 * Created by fukuisaeko on 2017-08-27.
 */

public class User extends BaseObservable {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Bindable
    public String getFirstName() {
        return this.firstName;
    }
    @Bindable
    public String getLastName() {
        return this.lastName;
    }
    public void setFirstName(String first) {
        this.firstName = first;
        notifyPropertyChanged(BR.firstName);
    }
}