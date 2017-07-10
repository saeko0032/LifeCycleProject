package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CICCC-CIRAC on 2017-07-10.
 */

public class ToastExample extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String sizeStr;
    private StringBuilder toppingStr;
    private Button toastBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);

        sizeStr = "Regular";
        toppingStr = new StringBuilder();

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        toastBtn = (Button) findViewById(R.id.toastBtn);
        toppingStr.append("topping : ");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) findViewById(checkedId);
                sizeStr = radioButton.getText().toString();
            }
        });

        toastBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                String msg = sizeStr + "\n" +toppingStr;
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(context, msg, duration);
                t.show();
            }
        });

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            CheckBox tempCheck = (CheckBox) findViewById(view.getId());
            toppingStr.append("" + tempCheck.getText().toString());
        }
    }
}
