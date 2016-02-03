package com.example.administrator.ifoodbox_006;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class ActShareSentMes extends AppCompatActivity {

    private Spinner mSpn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actsharesentmes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSpn = (Spinner) findViewById(R.id.spn);
        mSpn.setOnItemSelectedListener(spnOnItemSelected);
    }

    //下拉選單的選取事件 未完
    private AdapterView.OnItemSelectedListener spnOnItemSelected
            = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
        {
            // TODO Auto-generated method stub
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        {
            // TODO Auto-generated method stub
        }
    };
}
