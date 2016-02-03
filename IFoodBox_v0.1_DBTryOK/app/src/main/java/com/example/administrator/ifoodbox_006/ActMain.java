package com.example.administrator.ifoodbox_006;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class ActMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        InitialComponent();

    }

    private void InitialComponent() {
        ImageButton btnFood=(ImageButton)findViewById(R.id.btnFood);
        btnFood.setOnClickListener(btnFood_Click);

        ImageButton btnShoppingList=(ImageButton)findViewById(R.id.btnShoppingList);
        btnShoppingList.setOnClickListener(btnShoppingList_Click);

        ImageButton btnShare=(ImageButton)findViewById(R.id.btnShare);
        btnShare.setOnClickListener(btnShare_Click);
    }

    //點選愛分享的跳頁事件
    View.OnClickListener btnShare_Click =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //啟動
            Intent intent =new Intent(ActMain.this,ActShareMap.class);
            startActivity(intent);
        }
    };

    //點選購物清單的跳頁事件
    View.OnClickListener btnShoppingList_Click =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Log.v("bug","按鈕事件成功被觸發");
            //啟動
            Intent intent =new Intent(ActMain.this,ActBuyList.class);
            startActivity(intent);
        }
    };

    //點選購冰箱管理的彈跳對話框事件
    View.OnClickListener btnFood_Click = new View.OnClickListener() {
        public void onClick(View v) {

            AlertDialog.Builder build=new AlertDialog.Builder(ActMain.this);
            build.setTitle("管理我的雲端冰箱");
            build.setMessage("請選擇瀏覽或新增");
            build.setPositiveButton("新增食材",btnAdd_clik);
            build.setNegativeButton("瀏覽冰箱", btnOk_clik);
            Dialog message=build.create();
            message.show();
        }
    };

    DialogInterface.OnClickListener btnOk_clik = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent intent =new Intent(ActMain.this,ActFoodList.class);
            startActivity(intent);
        }
    };

    DialogInterface.OnClickListener btnAdd_clik = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent intent =new Intent(ActMain.this,ActFoodAdd.class);
            startActivity(intent);
        }
    };


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.act_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
