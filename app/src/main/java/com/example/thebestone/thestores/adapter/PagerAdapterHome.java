package com.example.thebestone.thestores.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.thebestone.thestores.fragment.FragmentHeaderContent;
import com.example.thebestone.thestores.helper.GlobalVariable;

/**
 * Created by thebestone on 10/17/17.
 */

public class PagerAdapterHome extends FragmentStatePagerAdapter {

    int itemCount = 3;
    GlobalVariable gv = new GlobalVariable();

    public PagerAdapterHome(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                gv.ProdNama = "contoh";
                FragmentHeaderContent fragmentHeaderContent = new FragmentHeaderContent();
                return fragmentHeaderContent;
            case 1:
                gv.ProdNama = "Ini contoh 1";
                FragmentHeaderContent fragmentHeaderContent1 = new FragmentHeaderContent();
                return fragmentHeaderContent1;
            case 2:
                gv.ProdNama = "Ini contoh 2";
                FragmentHeaderContent fragmentHeaderContent2 = new FragmentHeaderContent();
                return fragmentHeaderContent2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return itemCount;
    }
}
