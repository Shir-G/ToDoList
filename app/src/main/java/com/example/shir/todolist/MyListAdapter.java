package com.example.shir.todolist;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shir on 10/11/2015.
 */
public class MyListAdapter extends BaseAdapter {
    private static final String TAG=MyListAdapter.class.getSimpleName();
    ArrayList<String> myItems;

    public MyListAdapter(ArrayList<String> myItems) {
        this.myItems=myItems;
    }


    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int position) {
        return myItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        }
        TextView view = (TextView) convertView.findViewById(R.id.rowText);
        view.setText(myItems.get(position));
        Button button= (Button) view.findViewById(R.id.delete);

        final int i=position;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItems.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
