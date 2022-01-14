package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class logined extends AppCompatActivity {
    ViewPager viewPager;
    Animation ani_in,ani_out;
    Button login_button,sigup_button;
    EditText edit_login,edit_pass;
    CheckBox checkBox;
    TextView textView;
    FloatingActionButton ins,fb,gg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_logined);
        login_button = findViewById(R.id.btn_login);
        sigup_button= findViewById(R.id.btn_signup);
        ani_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        ani_out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_out_ani);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(logined.this,trangchu_activity.class);
                startActivity(intent);
            }
        });
        edit_login=findViewById(R.id.edt_user);
        edit_pass= findViewById(R.id.edt_password);
        checkBox=findViewById(R.id.nhotaikhoan);
        textView= findViewById(R.id.hoac);
        ins=findViewById(R.id.dn_ins);
        fb=findViewById(R.id.fn_fb);
        gg=findViewById(R.id.dn_gg);
        edit_login.setAnimation(ani_in);
        edit_pass.setAnimation(ani_in);
        checkBox.setAnimation(ani_in);
        textView.setAnimation(ani_in);
        ins.setAnimation(ani_in);
        fb.setAnimation(ani_in);
        gg.setAnimation(ani_in);
        login_button.setAnimation(ani_in);
        sigup_button.setAnimation(ani_in);

        sigup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(logined.this,singup_activity.class);
                startActivity(intent);
            }
        });
    }


}