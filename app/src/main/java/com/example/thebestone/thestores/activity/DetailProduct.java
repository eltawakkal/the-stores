package com.example.thebestone.thestores.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.PagerAdapterDetails;
import com.example.thebestone.thestores.helper.GlobalVariable;

import org.w3c.dom.Text;

/**
 * Created by thebestone on 10/10/17.
 */

public class DetailProduct extends AppCompatActivity {

    Toolbar toolbar;
    TextView tPname, tPtoko, tPharga;
    ViewPager pager;

    ImageView imgBack;

    PagerAdapterDetails adapterPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail);

        convig();
        onClickCollection();

        tPname.setText(GlobalVariable.ProdNama);
        tPharga.setText(GlobalVariable.ProdPrice);
        tPtoko.setText(GlobalVariable.ProdToko);

        pager.setAdapter(adapterPager);


    }

    private void convig() {

        tPname = (TextView) findViewById(R.id.tProdNameD);
        tPtoko = (TextView) findViewById(R.id.tProdTokoD);
        tPharga = (TextView) findViewById(R.id.tProdHargaD);

        imgBack = (ImageView) findViewById(R.id.imgBack);

        pager = (ViewPager) findViewById(R.id.viewPagerDetail);
        adapterPager = new PagerAdapterDetails(getSupportFragmentManager(), 3);
    }

    public void onClickCollection(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
