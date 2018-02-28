package com.example.thebestone.thestores.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.helper.SQLiteHelperQ;
import com.example.thebestone.thestores.model.Custom_header;
import com.example.thebestone.thestores.model.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thebestone on 10/7/17.
 */

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> {

    List<Items> mListData = new ArrayList<>();
    SQLiteHelperQ sqLiteHelperQ;
    SQLiteDatabase db;
    Cursor cursor;
    String NamaP, HargaP;

    public ListProductAdapter(Context context) {
        sqLiteHelperQ = new SQLiteHelperQ(context);
        db = sqLiteHelperQ.getReadableDatabase();

        try {
            cursor = db.rawQuery("select * from tbProduct", null);
            if (cursor.getCount() != 0){
                cursor.moveToFirst();

                for (int i=0; i<cursor.getCount(); i++){
                    cursor.moveToPosition(i);

                    NamaP = cursor.getString(1);
                    HargaP = cursor.getString(2);

//                    Toast.makeText(context, "nama : " + NamaP + " " + HargaP, Toast.LENGTH_SHORT).show();

                    addProduct(new Custom_header(NamaP, "akil shop", HargaP));
                }
            } else {
                Toast.makeText(context, "No database Recorded", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e){
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_list_product_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nama.setText(mListData.get(position).getProduct_name());
        holder.desc.setText(mListData.get(position).getStore_name());
        holder.price.setText(mListData.get(position).getProduct_price());
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, desc, price, category;
        public ViewHolder(View v) {
            super(v);

            nama = (TextView) v.findViewById(R.id.tProductNameList);
            desc = (TextView) v.findViewById(R.id.tProductDescList);
            price = (TextView) v.findViewById(R.id.tProductPriceList);
            category = (TextView) v.findViewById(R.id.tProductCategoryList);
        }
    }

    public void addProduct(Items items){
        mListData.add(items);
        notifyDataSetChanged();
    }

    public void removeProduct(Items items){
        mListData.remove(items);
        notifyDataSetChanged();
    }
}
