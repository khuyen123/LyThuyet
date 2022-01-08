package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class thuonghieu_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Button lammoi;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.thuonghieu_layout);
        bot_nav =findViewById(R.id.thuonghieu_bot_nav);
        tabLayout= findViewById(R.id.thuonghieu_tab_layout);
        viewPager = findViewById(R.id.thuonghieu_view_paper);
        bot_nav.setSelectedItemId(R.id.thuonghieu);

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

        tabLayout.setupWithViewPager(viewPager);
        thuonghieu_tab_adapter thuonghieuTabAdapter= new thuonghieu_tab_adapter(getSupportFragmentManager());
        thuonghieuTabAdapter.addFrag(new thuonghieu_dangsale_frag(),"Đang Sale");
        thuonghieuTabAdapter.addFrag(new thuonghieu_khaitruong_frag(),"Mới khai trương");
        thuonghieuTabAdapter.addFrag(new thuonghieu_doanhthu_frag(),"Doanh thu cao");
        viewPager.setAdapter(thuonghieuTabAdapter);
    }
}