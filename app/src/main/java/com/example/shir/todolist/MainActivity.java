package com.example.shir.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_TO_LIST = 1;
    ArrayList<String> myItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        refreshList(myItems);
    }

    public void addItem(){                                                                 //opens a new intent for adding an item
        Intent intent= new Intent(this, NewActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){          //adds the new item to the list
        if (requestCode==ADD_TO_LIST && resultCode== RESULT_OK){
            String addItem= data.getStringExtra("NEWITEM");
            myItems.add(addItem);
            refreshList(myItems);
        }
    }

    public void refreshList(ArrayList<String> myItems){                                     //gets the updated list
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new MyListAdapter(myItems));
    }

    public void openNewActivity(View view){
        Intent intent = new Intent(MainActivity.this, NewActivity.class);
        startActivityForResult(intent, ADD_TO_LIST);
    }


}
