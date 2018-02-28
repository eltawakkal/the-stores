package com.example.thebestone.thestores.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.GridHomeAdapter;
import com.example.thebestone.thestores.model.Custom_child;
import com.example.thebestone.thestores.model.Custom_header;
import com.example.thebestone.thestores.model.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thebestone on 10/6/17.
 */

public class FragmentStores extends Fragment {

    private static final int DEFAULT_SPAN_COUNT = 2;
    Toolbar toolbar;
    RecyclerView mRecycler;
    GridHomeAdapter mAdapter;
    List<Items> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_stores, container, false);

        config(view);

        return view;
    }

    public void config(View v){
        mRecycler = (RecyclerView) v.findViewById(R.id.mRecycler);
        mRecycler.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecycler.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(v.getContext(), DEFAULT_SPAN_COUNT);

        mAdapter = new GridHomeAdapter(FragmentStores.this, mList, gridLayoutManager, DEFAULT_SPAN_COUNT);

        mRecycler.setLayoutManager(gridLayoutManager);
        mRecycler.setAdapter(mAdapter);

        addData();
    }

    private void addData() {
        mAdapter.addItem(new Custom_header("Risol Maknyus", "Cah Grebekan", "1,5K/3pcs"));
        mAdapter.addItem(new Custom_child("Bakso Granat", "Toko Al Khairat", "5K/1pcs"));
        mAdapter.addItem(new Custom_child("Fried Cicken", "Punya Kita", "4,5K/1pcs"));
        mAdapter.addItem(new Custom_child("Mie Ayam", "Sumber Rejeki", "7K/1pcs"));
        mAdapter.addItem(new Custom_child("Risol Rudal", "Produk terbaik", "1,5K/4pcs"));
        mAdapter.addItem(new Custom_child("Kripik Lezat", "Bebas", "6K/10pcs"));
        mAdapter.addItem(new Custom_child("Pisang Lop", "Melangkah Lagi", "15K/1pcs"));
    }
}
