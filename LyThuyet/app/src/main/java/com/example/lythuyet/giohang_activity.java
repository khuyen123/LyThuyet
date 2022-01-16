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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class giohang_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Button muangay;
    Bundle bundle;
    TextView mota,dongia;
    TaiKhoan taiKhoan;
    String url="http://10.0.128.110/php_ltdd/getcart.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.giohang_layout);
        muangay= findViewById(R.id.button_muangay);
        getuser();
        muangay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putuser(thanhtoan_activity.class);
            }
        });
        bot_nav = findViewById(R.id.giohang_bottom_nav);
        mota=findViewById(R.id.mota);
        dongia=findViewById(R.id.dongia);
        bot_nav.setSelectedItemId(R.id.giohang);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu_activity.class));
                        putuser(trangchu_activity.class);
                        overridePendingTransition(0,0);
                        break;

                    case  R.id.thuonghieu:
                        putuser(thuonghieu_activity.class);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.theodoi:
                        putuser(theodoi_activity.class);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.taikhoan:
                        putuser(taikhoan_activity.class);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.giohang:
                        putuser(giohang_activity.class);
                        overridePendingTransition(0,0);
                        break;

                }
                return false;
            }
        });
        readJson(url);
    }
    public void getuser()
    {
        bundle=getIntent().getExtras();
        taiKhoan = new TaiKhoan(
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
        );
//        Toast.makeText(giohang_activity.this, taiKhoan.getHoten().toString(),Toast.LENGTH_SHORT).show();
    }
    public void putuser(Class activity)
    {
        Bundle bundle2= new Bundle();
        Intent intent= new Intent(this,activity);
        bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("matkhau",taiKhoan.getMatkhau());
        bundle2.putString("hoten",taiKhoan.getHoten());
        bundle2.putString("ngaysinh",taiKhoan.getNgaysinh());
        bundle2.putString("gioitinh",taiKhoan.getGioitinh());bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("sdt",taiKhoan.getSdt());
        bundle2.putInt("sodu",taiKhoan.getSodu());
        bundle2.putInt("id",taiKhoan.getId());
        bundle2.putString("diachi",taiKhoan.getDiachi());
        bundle2.putString("email",taiKhoan.getEmail());
        intent.putExtras(bundle2);
        startActivity(intent);
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
                                mota.setText(data.getString("mota"));
                                dongia.setText(String.valueOf(data.getInt("dongia"))+" VNĐ");
                            } catch (JSONException e) {
                               Toast.makeText(giohang_activity.this,e.toString(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(giohang_activity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);

    }
}