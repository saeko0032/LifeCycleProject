package com.example.ciccc_cirac.lifecycleproject;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static android.content.ContentValues.TAG;

/**
 * Created by saeko on 7/25/2017.
 */

public class AppController extends Application {
    private RequestQueue sharedRequestQueue;
    private static AppController sharedInstance;

    public void onCreate(){
        super.onCreate();
        sharedInstance = this;
    }

    public static synchronized  AppController getInstance() {
        return sharedInstance;
    }

    public RequestQueue getRequestQueue() {
        if(sharedRequestQueue == null) {
            sharedRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return sharedRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

}
