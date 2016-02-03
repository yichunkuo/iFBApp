package com.example.administrator.ifoodbox_006;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ActBuyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actbuylist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] values = new String[]{
                "Apple","Banana","Cat","Dog","Apple","Banana","Cat","Dog",
                "Apple","Banana","Cat","Dog","Apple","Banana","Cat","Dog","Apple","Banana","Cat","Dog"
        };

        ListAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_multiple_choice ,values);


        listView.setAdapter(adapter);



    }
}
