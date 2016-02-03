package com.example.administrator.ifoodbox_006;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mssql {
    private boolean _isOpened=false;
    String ipaddress, db, username, password;
    public static Connection connect;
    Statement st;
    public boolean isOpened()
    {
        return _isOpened;
    }

    @SuppressLint("NewApi")
    private Connection ConnectionHelper(String user, String password,
                                        String database, String server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL="jdbc:jtds:sqlserver://"+ server +";"
                    +"databaseName="+database+";charset=UTF8;user="+user
                    +";password="+password+";";
            connection = DriverManager.getConnection(ConnectionURL);

        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return connection;
    }

    public mssql () {

        //設定jdbc連結字串，請依你的SQL Server設定值修改

        try {
            ipaddress="ifoodboxserver.database.windows.net";
            db="iFoodBoxDatabase";
            username="systemadmin";
            password="1qaz2WSX";
            connect=ConnectionHelper(username,password,db,ipaddress);

            if (connect.isClosed()==false)
            {
                _isOpened=true;
            }
            else
            {
                _isOpened=false;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
