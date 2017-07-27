package com.example.ciccc_cirac.lifecycleproject;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by saeko on 7/27/2017.
 */

public class DateTimePickerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private TextView timeView;
    private TextView dateView;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        timeView = (TextView)findViewById(R.id.time_text);
        dateView = (TextView)findViewById(R.id.date_text);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource
                (this, R.array.placementdates,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
    }

    //日付変更時に再表示
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateView.setText(String.valueOf(year) + "/ " + String.valueOf(monthOfYear+1) + "/ " + String.valueOf(dayOfMonth));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeView.setText(String.valueOf(hourOfDay) + ": " + String.valueOf(minute));
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}
