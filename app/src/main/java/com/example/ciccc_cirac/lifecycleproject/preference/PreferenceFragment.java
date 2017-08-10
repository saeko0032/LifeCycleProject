package com.example.ciccc_cirac.lifecycleproject.preference;

import android.os.Bundle;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 7/28/2017.
 */

public class PreferenceFragment extends android.preference.PreferenceFragment {
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        addPreferencesFromResource(R.xml.preferences);

    }
}
