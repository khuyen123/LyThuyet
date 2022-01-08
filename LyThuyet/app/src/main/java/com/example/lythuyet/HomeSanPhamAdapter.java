package com.example.lythuyet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomeSanPhamAdapter extends BaseAdapter {

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
        return view;
    }
}
