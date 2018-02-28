package com.example.thebestone.thestores.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.AdapterPhotoDagang;
import com.example.thebestone.thestores.helper.SQLiteHelperQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by thebestone on 10/10/17.
 */

public class AddNewProduct extends AppCompatActivity {

    SQLiteHelperQ sqLiteHelperQ;
    SQLiteDatabase db;
    Cursor cursor;
    Random random;

    Bitmap bitmap;
    List<Bitmap> mListPhoto = new ArrayList<>();
    AdapterPhotoDagang adapter;

    EditText editProduct, editPrice, editDesc, editKomposisi;
    Button bSave;
    ImageView imgBack, imgCamera;
    RecyclerView mRecyclerPhoto;
    FloatingActionButton fabAddPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_product);

        config();
        onClickListenerCollection();

    }

    public void onClickListenerCollection(){

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama, harga, desc, ingr;

                nama = editProduct.getText().toString();
                harga = editPrice.getText().toString();
                ingr = editKomposisi.getText().toString();
                desc = editDesc.getText().toString();

                addNewData(nama, harga, desc, ingr);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        fabAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }


    private void config() {
        sqLiteHelperQ = new SQLiteHelperQ(this);

        editProduct = (EditText) findViewById(R.id.editProdukName);
        editDesc = (EditText) findViewById(R.id.editProdukDesc);
        editPrice = (EditText) findViewById(R.id.editProdukPrice);
        editKomposisi = (EditText) findViewById(R.id.editProdukIngrediens);
        fabAddPhoto = (FloatingActionButton) findViewById(R.id.fabAddPhoto);

        bSave = (Button) findViewById(R.id.bSaveProd);

        imgBack = (ImageView) findViewById(R.id.bntBackTambahDagang);
        imgCamera = (ImageView) findViewById(R.id.btnCamera);

        mRecyclerPhoto = (RecyclerView) findViewById(R.id.mRecyclerPhoto);

        random = new Random();

    }

    public void addNewData(String NamaP, String HargaP, String descP, String IngredientsP){
        String id = random.nextInt(1000) + "";
        try {
            db = sqLiteHelperQ.getWritableDatabase();
            db.execSQL("insert into tbProduct (ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DESC, PRODUCT_INGREDIENTS) VALUES" +
                    " ('"+ id +"','"+ NamaP +"','"+ HargaP +"','"+ descP +"','"+ IngredientsP +"')");

            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

        } catch (SQLException e){
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){

            bitmap = (Bitmap) data.getExtras().get("data");
            mListPhoto.add(bitmap);

            setRecyclerPhoto();

            fabAddPhoto.setVisibility(View.GONE);
            imgCamera.setVisibility(View.VISIBLE);

        }

    }

    public void setRecyclerPhoto(){
        adapter = new AdapterPhotoDagang(mListPhoto, this);
        mRecyclerPhoto.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
        mRecyclerPhoto.setAdapter(adapter);
    }
}
