package com.example.ciccc_cirac.lifecycleproject.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;

import java.util.ArrayList;

/**
 * Created by saeko on 8/10/2017.
 */

public class ProgressActivity extends AppCompatActivity {
    ListView list_cities;
    ProgressBar progress_cities;
    TextView text_cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_view);

        list_cities = (ListView)findViewById(R.id.thread_progress_lv);
        progress_cities = (ProgressBar) findViewById(R.id.thread_progressbar);
        text_cities = (TextView) findViewById(R.id.thread_progress_tv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        list_cities.setAdapter(adapter);

    }
    // inner class
//    class MyTask extends AsyncTask<void, void, void> {
//       ArrayAdapter<String> adapter;
//
//        @Override
//        protected void onPreExecute() {
//            adapter = (ArrayAdapter<String>) list_cities.getAdapter();
//            progress_cities.setVisibility(View.VISIBLE);
//
//        }
//
//        @Override
//        protected void doInBackground(String... params) {
//            for (String item:cities) {
//                publishProgress(item);
//            }
//        }
//
//        @Override
//        protected void onProgressUpdate(String... values) {
//            adapter.add(values[0]);
//            count++;
//            int val_progress = (int)((double) coount/ cities.length() * 100);
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            progress_cities.setVisibility(View.GONE);
//        }
//
//
//
//    }
}
