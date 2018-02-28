package com.example.thebestone.thestores.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.activity.ListLangganan;
import com.example.thebestone.thestores.activity.ListPesanan;
import com.example.thebestone.thestores.activity.ListPesananRutin;
import com.example.thebestone.thestores.activity.ListProduct;
import com.example.thebestone.thestores.activity.UserProfile;

/**
 * Created by thebestone on 10/6/17.
 */

public class FragmentProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_profile, container, false);

        TextView nonAktif = (TextView) view.findViewById(R.id.nonAktif);

        RelativeLayout listProd = (RelativeLayout) view.findViewById(R.id.listProduct);
        RelativeLayout listLangganan = (RelativeLayout) view.findViewById(R.id.listLangganan);
        RelativeLayout listProfile = (RelativeLayout) view.findViewById(R.id.listProfile);
        RelativeLayout listPesanan = (RelativeLayout) view.findViewById(R.id.listPelanggan);
        RelativeLayout listPesananRutin = (RelativeLayout) view.findViewById(R.id.listPEsananRutin);

        listProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListProduct.class));
            }
        });

        listLangganan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListLangganan.class));
            }
        });

        listProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), UserProfile.class));
            }
        });

        listPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListPesanan.class));
            }
        });

        listPesananRutin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListPesananRutin.class));
            }
        });

        nonAktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btnOke, btnBatal;

                final Dialog ask = new Dialog(getContext());

                ask.setContentView(R.layout.dialog_non_aktifkan);
                ask.setCancelable(false);

                btnOke = (Button) ask.findViewById(R.id.dialogNonAtktifOke);
                btnBatal = (Button) ask.findViewById(R.id.dialogNonAtktifBatal);

                btnOke.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ask.dismiss();
                    }
                });

                btnOke.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ask.dismiss();
                    }
                });

                ask.show();
            }
        });

        return view;
    }
}
