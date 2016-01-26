package com.example.irinaissakova.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.irinaissakova.todoapp.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        Log.d("myTag", "This ran");
        Log.d("myTag", "This ran too");


        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        ListView taskList = (ListView) findViewById(R.id.taskList);
        taskList.setAdapter(adapter);
        taskList.setOnItemClickListener(this);

    }

    public void addTask(View view) {
        String task = ((EditText) findViewById(R.id.newTask)).getText().toString();
        Log.d("myTag", task);
        list.add(task);
        adapter.notifyDataSetChanged();
        ((EditText) findViewById(R.id.newTask)).setText("");
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            list.remove(position);
            adapter.notifyDataSetChanged();
    }

}
