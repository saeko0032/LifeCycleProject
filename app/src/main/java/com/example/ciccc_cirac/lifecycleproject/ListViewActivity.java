package com.example.ciccc_cirac.lifecycleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by saeko on 7/18/2017.
 */

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_parent_layout);

        ListViewAdapter adapter = new ListViewAdapter(this);
        listView = (ListView)findViewById(R.id.listview_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i;
                switch(position) {
                    case 0:
                        i = new Intent(ListViewActivity.this,FrameLayoutActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(ListViewActivity.this,TableLayoutActivity.class);
                        //i.putExtra("value",editTxt1.getText().toString());
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(ListViewActivity.this,RelaytiveLayoutActivity.class);
                        //i.putExtra("value",editTxt1.getText().toString());
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(ListViewActivity.this,LinearLayoutActivity.class);
                        //i.putExtra("value",editTxt1.getText().toString());
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(ListViewActivity.this,ListViewActivity2.class);
                        //i.putExtra("value",editTxt1.getText().toString());
                        startActivity(i);
                        break;
                    case 5:
                        i = new Intent(ListViewActivity.this,GridViewActivity.class);
                        //i.putExtra("value",editTxt1.getText().toString());
                        startActivity(i);
                        break;
                    case 6:
                        i = new Intent(ListViewActivity.this,RecyclerViewActivity.class);
                        //i.putExtra("value",editTxt1.getText().toString());
                        startActivity(i);
                        break;
                }
            }
        });
    }

}
