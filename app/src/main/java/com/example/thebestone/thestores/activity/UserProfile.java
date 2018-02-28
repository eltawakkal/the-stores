package com.example.thebestone.thestores.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.thebestone.thestores.R;

import static android.R.attr.onClick;

/**
 * Created by thebestone on 10/20/17.
 */

public class UserProfile extends AppCompatActivity {

    ImageView btnBack, btnEdit;
    EditText editNamaToko, editEmail, editNotelp, editAlamat;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_user_profile);

        initial();
    }

    private void initial() {
        btnBack = (ImageView) findViewById(R.id.btnBackProfile);
        btnEdit = (ImageView) findViewById(R.id.btnEditProfile);

        editNamaToko = (EditText) findViewById(R.id.editNamaToko);
        editEmail = (EditText) findViewById(R.id.editEmailToko);
        editNotelp = (EditText) findViewById(R.id.editNotelpToko);
        editAlamat = (EditText) findViewById(R.id.editAlamatToko);

        btnSave = (Button) findViewById(R.id.btnSaveProfile);

        onClickListenerCollerction();
    }

    private void onClickListenerCollerction() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditEnabled(true);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditEnabled(false);
            }
        });
    }

    private void setEditEnabled(boolean b) {
        editNamaToko.setEnabled(b);
        editEmail.setEnabled(b);
        editNotelp.setEnabled(b);
        editAlamat.setEnabled(b);
    }

}
