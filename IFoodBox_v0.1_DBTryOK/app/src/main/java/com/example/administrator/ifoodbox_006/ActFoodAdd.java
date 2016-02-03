package com.example.administrator.ifoodbox_006;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActFoodAdd extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actfoodadd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InitialComponent();

    }

    private void InitialComponent() {
        ImageButton btnAddFood=(ImageButton)findViewById(R.id.btnAddFood);
        btnAddFood.setOnClickListener(btnAddFood_Click);
    }

    View.OnClickListener btnAddFood_Click =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //啟動
            LayoutInflater inflater = LayoutInflater.from(ActFoodAdd.this);
            final View addfood = inflater.inflate(R.layout.addfood, null);
            new AlertDialog.Builder(ActFoodAdd.this)
                    .setTitle("請填寫食材資訊")
                    .setView(addfood)
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EditText editText = (EditText) (addfood.findViewById(R.id.txtFoodName));

                            Toast.makeText(getApplicationContext(),
                                    editText.getText().toString() + "新增成功", Toast.LENGTH_SHORT).show();
                        }
                    })

                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                    .show();
                    }
        };


}
