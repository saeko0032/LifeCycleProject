package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by CICCC-CIRAC on 2017-07-10.
 */

public class ScoreCounter extends AppCompatActivity {
    Button scoreAPnt3Btn;
    Button scoreAPnt2Btn;
    Button scoreAPnt1Btn;
    Button scoreBPnt3Btn;
    Button scoreBPnt2Btn;
    Button scoreBPnt1Btn;
    Button resetBtn;
    TextView scoreATextView;
    TextView scoreBTextView;
    int scoreAValue;
    int scoreBValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point);
        scoreAValue = 0;
        scoreBValue = 0;
        scoreAPnt3Btn = (Button) findViewById(R.id.scoreAPnt3);
        scoreAPnt2Btn = (Button) findViewById(R.id.scoreAPnt2);
        scoreAPnt1Btn = (Button) findViewById(R.id.scoreAPnt1);
        scoreBPnt3Btn = (Button) findViewById(R.id.scoreBPnt3);
        scoreBPnt2Btn = (Button) findViewById(R.id.scoreBPnt2);
        scoreBPnt1Btn = (Button) findViewById(R.id.scoreBPnt1);
        resetBtn = (Button) findViewById(R.id.btnReset);
        scoreATextView = (TextView) findViewById(R.id.scoreA);
        scoreBTextView = (TextView) findViewById(R.id.scoreB);


        scoreAPnt3Btn.setOnClickListener( new View.OnClickListener(){
           @Override
            public void onClick(View view) {
               scoreAValue = scoreAValue + 3;
               displayScoreValue();
           }
        });

        scoreAPnt2Btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                scoreAValue = scoreAValue + 2;
                displayScoreValue();
            }
        });

        scoreAPnt1Btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                scoreAValue = scoreAValue + 1;
                displayScoreValue();
            }
        });

        scoreBPnt3Btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                scoreBValue = scoreBValue + 3;
                displayScoreValue();
            }
        });

        scoreBPnt2Btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                scoreBValue = scoreBValue + 2;
                displayScoreValue();
            }
        });

        scoreBPnt1Btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                scoreBValue = scoreBValue + 1;
                displayScoreValue();
            }
        });

        resetBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                scoreAValue = 0;
                scoreBValue = 0;
                displayScoreValue();
            }
        });
    }

    public void displayScoreValue() {
        scoreATextView.setText("" + scoreAValue);
        scoreBTextView.setText("" + scoreBValue);

    }
}
