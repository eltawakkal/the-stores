package com.example.thebestone.thestores.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.ListProductAdapter;
import com.example.thebestone.thestores.model.Items;

import java.util.List;

/**
 * Created by thebestone on 10/7/17.
 */

public class ListProduct extends AppCompatActivity {

    ListProductAdapter mAdapter;
    RecyclerView mRecycler;
    FloatingActionButton bAddNewProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_product);

        config();

        bAddNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListProduct.this, AddNewProduct.class));
            }
        });
    }

    private void config() {
        mRecycler = (RecyclerView) findViewById(R.id.mRecyclerListProd);
        bAddNewProduct = (FloatingActionButton) findViewById(R.id.bAddNewProduct);

        setmRecycler();
    }

    public void setmRecycler(){
        mAdapter = new ListProductAdapter(getApplicationContext());
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setHasFixedSize(true);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setmRecycler();
    }

    public void finishAll(View v){
        finish();
    }
}
