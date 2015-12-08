package com.example.shir.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_TO_LIST = 1;
    private final ArrayList<String> myItems = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        myItems.add("test1");
        myItems.add("test2");
        refreshList(myItems);
    }

    public void addItem(View view){                                                                 //opens a new intent for adding an item
        Intent intent= new Intent(MainActivity.this, NewActivity.class);
        startActivityForResult(intent, ADD_TO_LIST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){          //adds the new item to the list
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==ADD_TO_LIST && resultCode== RESULT_OK){
            String addItem= data.getStringExtra("NEWITEM");
            myItems.add(addItem);
            refreshList(myItems);
        }
    }

    private void refreshList(ArrayList<String> myItems){                                     //gets the updated list
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new MyListAdapter(myItems));
    }

}
