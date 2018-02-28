package com.example.thebestone.thestores.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.ListViewAdapter;
import com.example.thebestone.thestores.model.CustomerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thebestone on 10/23/17.
 */

public class ListPesananRutin extends AppCompatActivity {

    TabLayout tabLayout;
    ListView mList;

    ListViewAdapter adapter;
    List<CustomerModel> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pesanan_rutin);

        config();
        onSelectTab();

        mData.clear();
        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
        setListAdapter();
    }

    private void config() {
        mList = (ListView) findViewById(R.id.listSelesai);
        tabLayout = (TabLayout) findViewById(R.id.tabPesananRutin);
    }

    public void onSelectTab(){
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                    case 1:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                    case 2:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                    case 3:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                    case 4:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                    case 5:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                    case 6:
                        mData.clear();
                        mData.add(new CustomerModel("Kripik Singkong", "khairil"));
                        setListAdapter();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void setListAdapter(){
        adapter = new ListViewAdapter(getApplicationContext(), mData);
        mList.setAdapter(adapter);
    }
}
