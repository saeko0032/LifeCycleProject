package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by saeko on 7/28/2017.
 */

public class MainPreferenceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferenceFragment()).commit();
    }
}
