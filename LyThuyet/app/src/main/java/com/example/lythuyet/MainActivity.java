package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        bot_nav = findViewById(R.id.bottom_nav);
        bot_nav.setSelectedItemId(R.id.trangchu);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu_activity.class));

                        overridePendingTransition(2,2);
                        break;

                    case  R.id.thuonghieu:
                        startActivity(new Intent(getApplicationContext(),thuonghieu_activity.class));

                        overridePendingTransition(2,2);
                        break;
                    case R.id.theodoi:
                        startActivity(new Intent(getApplicationContext(),theodoi_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.giohang:
                        startActivity(new Intent(getApplicationContext(),giohang_activity.class));

                        overridePendingTransition(0,0);
                        break;

                    case R.id.taikhoan:
                        startActivity(new Intent(getApplicationContext(),taikhoan_activity.class));

                        overridePendingTransition(0,0);
                        break;

                }
                return false;
            }
        });
    }
}