package com.example.thebestone.thestores.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.ListViewAdapter;
import com.example.thebestone.thestores.model.CustomerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thebestone on 10/18/17.
 */

public class ListLangganan extends AppCompatActivity {

    List<CustomerModel> modelListData = new ArrayList<>();
    ListViewAdapter adapter;
    ListView mListPelanggan;

    ImageView imgBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_langganan);

        addData();

        adapter = new ListViewAdapter(getApplicationContext(), modelListData);

        mListPelanggan = (ListView) findViewById(R.id.listSelesai);
        mListPelanggan.setAdapter(adapter);

        onClickListenerCollection();
    }

    private void addData() {
        modelListData.add(new CustomerModel("Fadhli Al Mutawakkil", "082339446195"));
        modelListData.add(new CustomerModel("Azizah", "082140598649"));
        modelListData.add(new CustomerModel("Nurul", "085232074369"));

        imgBack = (ImageView) findViewById(R.id.imgBackListLangganan);
    }

    public void onClickListenerCollection(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
