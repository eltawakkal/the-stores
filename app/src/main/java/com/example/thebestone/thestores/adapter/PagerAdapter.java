package com.example.thebestone.thestores.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.thebestone.thestores.fragment.FragmentKeranjangDIpesan;
import com.example.thebestone.thestores.fragment.FragmentKeranjangSelesai;

/**
 * Created by thebestone on 10/11/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int pageCount;

    public PagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.pageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentKeranjangDIpesan pesan = new FragmentKeranjangDIpesan();
                return pesan;
            case 1:
                FragmentKeranjangSelesai selesai = new FragmentKeranjangSelesai();
                return selesai;
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageCount;
    }
}
