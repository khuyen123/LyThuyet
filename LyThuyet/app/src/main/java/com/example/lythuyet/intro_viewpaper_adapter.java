package com.example.lythuyet;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class intro_viewpaper_adapter extends PagerAdapter {
    Context mcontext;
    List<intro_screen_item> mlistScreen;

    public intro_viewpaper_adapter(Context mcontext, List<intro_screen_item> mlistScreen) {
        this.mcontext = mcontext;
        this.mlistScreen = mlistScreen;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen= inflater.inflate(R.layout.intro_layout_screen,null);
        ImageView imgSlide= layoutScreen.findViewById(R.id.intro_img);
        TextView title= layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.intro_description);
        title.setText(mlistScreen.get(position).getTitle());
        description.setText(mlistScreen.get(position).getDescription());
        imgSlide.setImageResource(mlistScreen.get(position).getIntroImg());
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return mlistScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
