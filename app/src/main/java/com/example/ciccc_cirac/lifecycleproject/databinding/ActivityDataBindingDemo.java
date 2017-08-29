package com.example.ciccc_cirac.lifecycleproject.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;
import com.example.ciccc_cirac.lifecycleproject.databinding.ActivityDataBinding;

/**
 * Created by fukuisaeko on 2017-08-27.
 */

public class ActivityDataBindingDemo extends AppCompatActivity implements MyHandlers {
    private User myUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layoutfile activity_dat ->ActivityData + Binding
        ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        myUser = new User("Frist", "Last");
        binding.setUser(myUser);
        // set eventhandler
        binding.setHandlers(this);
    }

    @Override
    public void onChangeClick(View view) {
        myUser.setFirstName("test");
    }
}
