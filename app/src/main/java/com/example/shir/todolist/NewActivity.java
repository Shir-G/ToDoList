package com.example.shir.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {                            //the new window for adding a new item

    Intent newActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        newActivityIntent=getIntent();
    }

    public void addTask(){
        EditText newItem = (EditText) findViewById(R.id.textField);
        newActivityIntent.putExtra("NEWITEM",newItem.getText().toString());
        setResult(RESULT_OK, newActivityIntent);
        finish();
    }
}
