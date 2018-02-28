package com.example.thebestone.thestores.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.thebestone.thestores.fragment.FragmentPict;

/**
 * Created by thebestone on 10/21/17.
 */

public class PagerAdapterDetails extends FragmentStatePagerAdapter {

    int pagerCount;

    public PagerAdapterDetails(FragmentManager fm, int pagerCount) {
        super(fm);
        this.pagerCount = pagerCount;
    }

    @Override
    public Fragment getItem(int position) {

        return new FragmentPict();
    }

    @Override
    public int getCount() {
        return pagerCount;
    }
}
