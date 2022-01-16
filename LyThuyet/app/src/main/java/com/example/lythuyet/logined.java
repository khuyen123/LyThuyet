package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class logined extends AppCompatActivity {
    Animation ani_in,ani_out;
    Button login_button,sigup_button;
    EditText edit_login,edit_pass;
    CheckBox checkBox;
    TextView textView,alertusser,allertpass;
    FloatingActionButton ins,fb,gg;
    ArrayList<TaiKhoan> arrayList;
    Bundle bundle;
    String url="http://10.0.134.32/php_ltdd/gettaikhoan.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_logined);
        anhxa();
        arrayList= new ArrayList<>();
        ani_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        ani_out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_out_ani);
        setanimation();
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap(edit_login.getText().toString(),edit_pass.getText().toString());
            }
        });
        sigup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(logined.this,singup_activity.class);
                startActivity(intent);
            }
        });
        readJson(url);
        setData();

    }
    private void setanimation()
    {
        edit_login.setAnimation(ani_in);
        edit_pass.setAnimation(ani_in);
        checkBox.setAnimation(ani_in);
        textView.setAnimation(ani_in);
        ins.setAnimation(ani_in);
        fb.setAnimation(ani_in);
        gg.setAnimation(ani_in);
        login_button.setAnimation(ani_in);
        sigup_button.setAnimation(ani_in);

    }
    private void anhxa()
    {
        edit_login=findViewById(R.id.username);
        edit_pass= findViewById(R.id.password);
        checkBox=findViewById(R.id.nhotaikhoan);
        textView= findViewById(R.id.hoac);
        ins=findViewById(R.id.dn_ins);
        fb=findViewById(R.id.fn_fb);
        gg=findViewById(R.id.dn_gg);
        login_button = findViewById(R.id.btn_login);
        sigup_button= findViewById(R.id.btn_signup);
        alertusser=findViewById(R.id.alertusername);
        allertpass=findViewById(R.id.alertpassword);
    }
    private void readJson(String url)
    {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++)
                        {
                            try {
                                JSONObject data= response.getJSONObject(i);
                                arrayList.add(new TaiKhoan(
                                        data.getInt("id"),
                                        data.getString("tendangnhap"),
                                        data.getString("matkhau"),
                                        data.getString("hoten"),
                                        data.getString("ngaysinh"),
                                        data.getString("diachi"),

                                        data.getString("gioitinh"),
                                        data.getString("email"),
                                        data.getString("sdt"),
                                        data.getInt("sodu")
                                ));
                            } catch (JSONException e) {
//                                Toast.makeText(logined.this, e.toString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(logined.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);

    }
    private void setData()
    {
        bundle = getIntent().getExtras();
        arrayList.add(new TaiKhoan(
           1,
           "khuyen",
           "khuyen",
           "Phạm Khuyến",
           "05/01/2001",
           "Vinh An, Phú Vang, Thừa Thiên Huế",
           "Nam",
           "khuyenphamno0@gmail.com",
           "0336482917",
           15000
        ));
        arrayList.add(new TaiKhoan(
                2,
                "tronghung",
                "hung",
                "Nguyễn Trọng Hưng",
                "12/12/2001",
                "Hà Tĩnh",
                "Nam",
                "tronghung@gmail.com",
                "0123456789",
                15000
        ));
        if(bundle!=null) {
            arrayList.add(new TaiKhoan(
                    bundle.getInt("id", 0),
                    bundle.getString("tendangnhap"),
                    bundle.getString("matkhau"),
                    bundle.getString("hoten"),
                    bundle.getString("ngaysinh"),
                    bundle.getString("diachi"),
                    bundle.getString("gioitinh"),
                    bundle.getString("email"),
                    bundle.getString("sdt"),
                    bundle.getInt("sodu")
            ));
        }
    }
    private TaiKhoan kiemtrausername(String username)
    {
        for (TaiKhoan user: arrayList) {
            if (user.getTendangnhap().equals(username))
                return user;
        }
        return null;
    }
    private int kiemtrapass(String username,String pass) {
        TaiKhoan taiKhoanPass;
        taiKhoanPass = kiemtrausername(username);
        if (taiKhoanPass == null)
            return 0;
        else
        {
            if((taiKhoanPass.getMatkhau().equals(pass)))
                return 1;
            else
            {
                return 2;
            }
        }
    }
    private void DangNhap(String username,String password)
    {
        TaiKhoan user=kiemtrausername(username);

        if(edit_login.getText().toString()=="") {
            alertusser.setText("Vui lòng nhập tên đăng nhập");
            edit_login.setBackgroundResource(R.drawable.alert_edit);
        }else

                if(edit_pass.getText().toString()=="") {
                    allertpass.setText("Vui lòng nhập mật khẩu");
                    edit_pass.setBackgroundResource(R.drawable.alert_edit);
                }else
        {
            if(kiemtrapass(username,password)==1)
            {

                putIntent(user);

            }else
            if(kiemtrapass(username,password)==2)
            {
                allertpass.setText("Sai mật khẩu");
                edit_pass.setBackgroundResource(R.drawable.alert_edit);
            } else
            if(kiemtrapass(username,password)==0) {
                alertusser.setText("Sai tài khoản");
                edit_login.setBackgroundResource(R.drawable.alert_edit);
            }
        }
                edit_pass.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        alertusser.setText("");
                        edit_login.setBackgroundResource(R.drawable.edt_boder);
                        alertusser.setText("");
                        edit_pass.setBackgroundResource(R.drawable.edt_boder);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                edit_login.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        alertusser.setText("");
                        edit_login.setBackgroundResource(R.drawable.edt_boder);
                        alertusser.setText("");
                        edit_pass.setBackgroundResource(R.drawable.edt_boder);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
    }
    public void putIntent(TaiKhoan taiKhoan)
    {   Bundle bundle2= new Bundle();
        Intent intent= new Intent(logined.this,trangchu_activity.class);
        bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("matkhau",taiKhoan.getMatkhau());
        bundle2.putString("hoten",taiKhoan.getHoten());
        bundle2.putString("ngaysinh",taiKhoan.getNgaysinh());
        bundle2.putString("gioitinh",taiKhoan.getGioitinh());
        bundle2.putString("sdt",taiKhoan.getSdt());
        bundle2.putInt("sodu",taiKhoan.getSodu());
        bundle2.putInt("id",taiKhoan.getId());
        bundle2.putString("diachi",taiKhoan.getDiachi());
        bundle2.putString("email",taiKhoan.getEmail());
        intent.putExtras(bundle2);
        startActivity(intent);
    }
}