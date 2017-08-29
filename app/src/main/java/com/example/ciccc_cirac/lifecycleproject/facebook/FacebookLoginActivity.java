package com.example.ciccc_cirac.lifecycleproject.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by fukuisaeko on 2017-08-29.
 */

public class FacebookLoginActivity extends AppCompatActivity {
    CallbackManager callbackMnger;
    TextView status;
    LoginButton lginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(this);
        callbackMnger = CallbackManager.Factory.create();
        setContentView(R.layout.activity_facebook_login);

        status = (TextView)findViewById(R.id.text_status);
        lginBtn = (LoginButton)findViewById(R.id.facebook_login_btn);

        lginBtn.registerCallback(callbackMnger,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        status.setText("LOGIN SUCCESSFULL\n"+
                                loginResult.getAccessToken().getUserId());
                    }
                    @Override
                    public void onCancel() {
                        status.setText("LOGIN CANCELLED");

                    }

                    @Override
                    public void onError(FacebookException error) {
                        status.setText("ERROR " + error.getMessage());
                    }
                });
        lginBtn.setReadPermissions("public_profile");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackMnger.onActivityResult(requestCode,resultCode,data);
    }
}