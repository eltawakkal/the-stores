package com.example.thebestone.thestores.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.thebestone.thestores.R;

/**
 * Created by thebestone on 10/22/17.
 */

public class ListPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_selesainpesan);

        setSupportActionBar(new Toolbar(ListPesanan.this, null));

    }
}
