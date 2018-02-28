package com.example.thebestone.thestores.activity;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.thebestone.thestores.R;

/**
 * Created by thebestone on 10/7/17.
 */

public class Search extends AppCompatActivity {

    ImageView btBack;
    SearchView tSearch;
    String[] dataProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_search);

        inisial();

        tSearch.setIconified(false);
        tSearch.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                finish();
                return false;
            }
        });

    }

    private void inisial() {
//        btBack = (ImageView) findViewById(R.id.btBack);
        tSearch = (SearchView) findViewById(R.id.tSearch);

        tSearch.setSuggestionsAdapter(new SimpleCursorAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1, null,
                new String[] { SearchManager.SUGGEST_COLUMN_TEXT_1 },
                new int[] { android.R.id.text1 }));
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
