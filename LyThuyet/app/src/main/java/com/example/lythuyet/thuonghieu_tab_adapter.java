package com.example.lythuyet;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class thuonghieu_tab_adapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> listFrag= new ArrayList<>();
    private final ArrayList<String> listTitle= new ArrayList<>();
    public thuonghieu_tab_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFrag.get(position);
    }
    @NonNull
    @Override
    public int getCount() {
        return listFrag.size();
    }
    public void addFrag(Fragment fragment,String title)
    {
        listFrag.add(fragment);
        listTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
