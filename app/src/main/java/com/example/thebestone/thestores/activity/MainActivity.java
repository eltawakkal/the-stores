package com.example.thebestone.thestores.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.GridHomeAdapter;
import com.example.thebestone.thestores.fragment.FragmentKeranjang;
import com.example.thebestone.thestores.fragment.FragmentProfile;
import com.example.thebestone.thestores.fragment.FragmentStores;
import com.example.thebestone.thestores.helper.SQLiteHelperQ;
import com.example.thebestone.thestores.model.Items;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_SPAN_COUNT = 2;
    RecyclerView mRecycler;
    GridHomeAdapter mAdapter;
    List<Items> mList = new ArrayList<>();
    BottomNavigationView bottomNav;

    FragmentStores frgStore;
    FragmentKeranjang frgKeranjang;
    FragmentProfile frgProfile;

    ImageView imgSearch;

    SQLiteHelperQ sqLiteHelperQ;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        toolbar = (Toolbar) findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
        setTitle("");

        createDatabase();

        /*imgSearch = (ImageView) findViewById(R.id.action_search);
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Search.class);
                startActivityForResult(i, 0);
                overridePendingTransition(0, 0);
            }
        });*/

        frgStore = new FragmentStores();
        frgKeranjang = new FragmentKeranjang();
        frgProfile = new FragmentProfile();

        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, frgStore).commit();

        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.action_home);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_keranjang:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, frgKeranjang).commit();
                        item.setChecked(true);
                        break;
                    case R.id.action_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, frgStore).commit();
                        item .setChecked(true);
                        break;
                    case R.id.action_profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, frgProfile).commit();
                        item.setChecked(true);
                        break;
                }
                return false;
            }
        });
    }

    public void createDatabase(){
        sqLiteHelperQ = new SQLiteHelperQ(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_notif:
                break;
            case R.id.action_search:
                startActivity(new Intent(this, Search.class));
                break;
        }
        return false;
    }
}
