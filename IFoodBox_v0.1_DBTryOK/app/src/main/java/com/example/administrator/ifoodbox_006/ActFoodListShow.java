package com.example.administrator.ifoodbox_006;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActFoodListShow extends Activity {
    mssql sqll=new mssql();
    ResultSet rs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actfoodlistshow);
        IncialComponent();

        try{
            Statement stmt=sqll.connect.createStatement();
            String sql="SELECT * FROM iShare";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                txt1.setText("分享食物："+rs.getString("iShareFoodName").toString());
                txt2.setText("分享數量："+rs.getInt("iShareFoodCount"));
                txt3.setText("食物地址："+rs.getString("iShareFoodAddress").toString());
            }
            rs.close();
            sqll.connect.close();

        }
        catch(SQLException e){

        }

    }
    private void IncialComponent() {
        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
    }
    TextView txt1;
    TextView txt2;
    TextView txt3;
}