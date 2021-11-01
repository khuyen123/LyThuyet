package com.example.lythuyet;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager intro_screenPager;
    intro_viewpaper_adapter intro_viewpaper_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        List<intro_screen_item> mlist = new ArrayList<>();
        mlist.add(new intro_screen_item("Rèm chất lượng","Dễ dàng lắp đặt với các loại cửa",R.drawable.catan));
        mlist.add(new intro_screen_item("Màn ngủ chất lượng","Đẩy lùi toàn bộ côn trùng",R.drawable.victory));
        mlist.add(new intro_screen_item("Rèm baby","Dễ thương cute",R.drawable.baby));
        mlist.add(new intro_screen_item("Hội chị em","Các chàng trai nhóm 13",R.drawable.baby));
        intro_screenPager = findViewById(R.id.intro_viewpager);
        intro_viewpaper_adapter = new intro_viewpaper_adapter(this,mlist);
        intro_screenPager.setAdapter(intro_viewpaper_adapter);
    }
}