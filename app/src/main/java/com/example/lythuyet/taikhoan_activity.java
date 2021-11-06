package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class taikhoan_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Button caidat, theodoi,dangxuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.taikhoan_layout);
        bot_nav = findViewById(R.id.taikhoan_bottom_nav);
        dangxuat= findViewById(R.id.but_dangxuat);
        caidat= findViewById(R.id.caidat_taikhoan);
        theodoi= findViewById(R.id.taikhoan_ds_theodoi);
        bot_nav.setSelectedItemId(R.id.taikhoan);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu_activity.class));

                        overridePendingTransition(0,0);
                        break;

                    case  R.id.thuonghieu:
                        startActivity(new Intent(getApplicationContext(),thuonghieu_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.theodoi:
                        startActivity(new Intent(getApplicationContext(),theodoi_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.taikhoan:
                        startActivity(new Intent(getApplicationContext(),taikhoan_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.giohang:
                        startActivity(new Intent(getApplicationContext(),giohang_activity.class));

                        overridePendingTransition(0,0);
                        break;

                }
                return false;
            }
        });
        caidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(taikhoan_activity.this,caidat_taikhoan_activity.class);
                startActivity(intent);
            }
        });
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(taikhoan_activity.this,logined.class);
                startActivity(intent);
            }
        });
        theodoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(taikhoan_activity.this,theodoi_activity.class);
                startActivity(intent);
            }
        });
    }

}