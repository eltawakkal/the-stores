package com.example.thebestone.thestores.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.activity.DetailProduct;
import com.example.thebestone.thestores.helper.GlobalVariable;

/**
 * Created by thebestone on 10/17/17.
 */

public class FragmentHeaderContent extends Fragment {

    TextView tPnama, tPtoko, tPharga;
    ImageView imgProd;
    private String prodName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_header_content, container, false);

        tPnama = (TextView) v.findViewById(R.id.tProdukNameHeader);
        tPtoko = (TextView) v.findViewById(R.id.tStoreNameHeader);
        tPharga = (TextView) v.findViewById(R.id.tPriceHeader);
        imgProd = (ImageView) v.findViewById(R.id.imgProdHeader);

        setPname(GlobalVariable.ProdNama);

        imgProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DetailProduct.class));
            }
        });
        return v;
    }

    public void setPname(String ProductName){
        tPnama.setText(ProductName);
    }
}
