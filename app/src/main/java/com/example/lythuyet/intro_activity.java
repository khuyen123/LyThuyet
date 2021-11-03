package com.example.lythuyet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SharedMemory;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class intro_activity extends AppCompatActivity {
    private ViewPager intro_screenPager;
    TabLayout intro_tab;
    Button next_button,get_start;
    Animation button_ani;
    int position=0;
    intro_viewpaper_adapter intro_viewpaper_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(restore())
        {
            Intent intent = new Intent(getApplicationContext(),logined.class);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        List<intro_screen_item> mlist = new ArrayList<>();
        mlist.add(new intro_screen_item("Mua hàng Online","Đặt hàng và thanh toán Online, sau đó sản phẩm sẽ được gửi đến bạn một cách nhanh nhóng",R.drawable.img2));
        mlist.add(new intro_screen_item("Thanh toán Online","Thanh toán đơn giản, tiện lợi, nhanh chóng",R.drawable.img3));
        mlist.add(new intro_screen_item("Hội chị em","Các chàng trai nhóm 13",R.drawable.baby));
        intro_screenPager = findViewById(R.id.intro_viewpager);
        intro_tab = findViewById(R.id.tab_intro);
        next_button = findViewById(R.id.next_button);
        get_start = findViewById(R.id.start);
        button_ani= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        intro_viewpaper_adapter = new intro_viewpaper_adapter(this,mlist);
        intro_screenPager.setAdapter(intro_viewpaper_adapter);
        intro_tab.setupWithViewPager(intro_screenPager);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position= intro_screenPager.getCurrentItem();
                if(position<mlist.size())
                {
                    position++;
                    intro_screenPager.setCurrentItem(position);
                }
                    if(position==mlist.size()-1)
                    {
                        loadLastScreen();
                    }
            }
        });
        intro_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mlist.size()-1)
                    loadLastScreen();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                    loadunselected();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                    loadLastScreen();
            }
        });
        get_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(intro_activity.this,logined.class);
                startActivity(intent);
                savePrefData();
                finish();
            }
        });
    }
    private boolean restore()
    {
        SharedPreferences pref= getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        Boolean isIntroStarted = pref.getBoolean("isIntroOpened",false);
        return isIntroStarted;
    }

    private void savePrefData() {
        SharedPreferences preferences= getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();

    }

    private void loadLastScreen() {
        get_start.setVisibility(View.VISIBLE);
        get_start.setAnimation(button_ani);
        intro_tab.setVisibility(View.INVISIBLE);
        next_button.setVisibility(View.INVISIBLE);
    }
    private void loadunselected() {
        get_start.setVisibility(View.INVISIBLE);
        intro_tab.setVisibility(View.VISIBLE);
        next_button.setVisibility(View.VISIBLE);

    }

}