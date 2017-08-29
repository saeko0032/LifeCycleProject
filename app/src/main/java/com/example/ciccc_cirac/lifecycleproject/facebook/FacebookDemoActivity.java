package com.example.ciccc_cirac.lifecycleproject.facebook;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ciccc_cirac.lifecycleproject.R;

import java.io.InputStream;

/**
 * Created by saeko on 8/28/2017.
 */

public class FacebookDemoActivity extends AppCompatActivity {
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        b1 = (Button)findViewById(R.id.facebook_btn1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                Uri imgUri = Uri.parse( "android.resource://com.example.ciccc_cirac.lifecycleproject.facebook/*");
                try {
                    InputStream in = getContentResolver().openInputStream(imgUri);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                shareIntent.setType("image/jpeg");
                shareIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
                startActivity(Intent.createChooser(shareIntent, "sharing using"));
            }
        });
    }
}