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
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomnav = findViewById(R.id.bottom_nav);
        bottomnav.setOnNavigationItemSelectedListener(navSelect);
        getSupportFragmentManager().beginTransaction().replace(R.id.frament_layout, new trangchu_class()).commit();
        viewPager=findViewById(R.id.view_paper);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navSelect =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFrag = null;
                    switch(menuItem.getItemId())
                    {
                        case R.id.thuonghieu: {
                            selectedFrag = new thuonghieu_class();

                            break;
                        }
                        case R.id.theodoi: {
                            selectedFrag = new theodoi_class();
                            break;
                        }
                        case R.id.giohang:{
                            selectedFrag = new giohang_class();
                            break;
                        }
                        case R.id.trangchu:{
                            selectedFrag = new trangchu_class();
                            break;
                        }
                        case R.id.taikhoan: {
                            selectedFrag = new taikhoan_class();
                        }
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frament_layout,selectedFrag).commit();
                    return true;
                }
            };
}