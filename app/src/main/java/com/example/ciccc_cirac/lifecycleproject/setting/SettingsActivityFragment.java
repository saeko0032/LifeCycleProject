package com.example.ciccc_cirac.lifecycleproject.setting;

import android.preference.*;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SettingsActivityFragment extends android.preference.PreferenceFragment {

    public SettingsActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
