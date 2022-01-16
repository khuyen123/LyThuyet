package com.example.lythuyet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeSanPhamAdapter extends BaseAdapter {
    Bundle bundle;
    TaiKhoan tai;
    private Context context;
    private int layout;
    // tạo danh sách chứa đối tượng Sản phẩm;
    private List<HomeSanPham>  sanPhamList;

    public HomeSanPhamAdapter(Context context, int layout, List<HomeSanPham> sanPhamList) {
        this.context = context;
        this.layout = layout;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int getCount() {
        return sanPhamList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // mỗi dòng trả về item
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        // ánh xạ
        TextView txvTen= view.findViewById(R.id.home_name);
        TextView txvMota= view.findViewById(R.id.home_des);
        ImageView imgHinh=view.findViewById(R.id.home_img);
        Button btnChiTiet= view.findViewById(R.id.home_butt);

        // Gán giá trị vào HomeSanPham
        HomeSanPham homeSanPham= sanPhamList.get(i);
        txvTen.setText(homeSanPham.getTenShop());
        txvMota.setText((homeSanPham.getMoTa()));
        imgHinh.setImageResource(homeSanPham.getAnh());
        btnChiTiet.setText(homeSanPham.getChiTiet());
        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoagiohang();
                RequestQueue requestQueue= Volley.newRequestQueue(context);
                StringRequest stringRequest= new StringRequest(Request.Method.POST, "http://10.0.128.110/php_ltdd/themgiohang.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.trim().equals("sucsess"))
                                {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                        builder.setTitle("Mua hàng");
                                        builder.setMessage("Để mua sản phẩm, vào trang giỏ hàng và thanh toán!");
                                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    });
                                    builder.show();
                                } else
                                    Toast.makeText(context,"thất bại",Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params= new HashMap<>();
                        params.put("tensanpham",homeSanPham.getTenShop().trim());
                        params.put("mota",homeSanPham.getMoTa().trim());
                        params.put("dongia",String.valueOf(130421));
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
        return view;
    }
    private void xoagiohang()
    {
        String url2="http://10.0.128.110/php_ltdd/deletegiohang.php";
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("sucsess"))
                        {

                        } else
                            Toast.makeText(context, "Lỗi thêm", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(stringRequest);
    }

}
