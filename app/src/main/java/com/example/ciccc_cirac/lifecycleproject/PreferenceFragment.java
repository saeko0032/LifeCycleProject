package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;

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
