package com.example.administrator.ifoodbox_006;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActShareMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actsharemap);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InitialComponent();
    }

    private void InitialComponent() {
        Button btnToShareMes=(Button)findViewById(R.id.btnToShareMes);
        btnToShareMes.setOnClickListener(btnToShareMes_Click);
    }

    //點選愛分享的跳頁事件
    View.OnClickListener btnToShareMes_Click =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //啟動
            Intent intent =new Intent(ActShareMap.this,ActShareSentMes.class);
            startActivity(intent);
        }
    };
}
