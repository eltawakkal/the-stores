package com.example.thebestone.thestores.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.PagerAdapter;

/**
 * Created by thebestone on 10/6/17.
 */

public class FragmentKeranjang extends Fragment {

    PagerAdapter pagerAdapter;
    ViewPager viewPager;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_keranjang, container, false);

        config();

        return view;
    }

    public void config(){

        pagerAdapter = new PagerAdapter(getFragmentManager(), 2);
        viewPager = (ViewPager) view.findViewById(R.id.contentPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tab = (TabLayout) view.findViewById(R.id.tabLayout);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        try {
            config();
        }catch (Exception e){

        }
    }
}
