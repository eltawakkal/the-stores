package com.example.thebestone.thestores.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.activity.DetailProduct;
import com.example.thebestone.thestores.helper.GlobalVariable;
import com.example.thebestone.thestores.model.Items;
import com.example.thebestone.thestores.view.HolderHome;

import java.util.List;

/**
 * Created by thebestone on 10/5/17.
 */

public class GridHomeAdapter extends RecyclerView.Adapter<HolderHome> {

    private final int mDefaultSpanCount;
    private List<Items> mListItem;
    Fragment fragment;
    int[] imgProduct = {R.drawable.produk1, R.drawable.product2, R.drawable.product3, R.drawable.product4};

    int imgCount = 0;

    public GridHomeAdapter(Fragment fragment, List<Items> mListItem, GridLayoutManager gridLayoutManager, final int defaultSpanCount) {
        this.fragment = fragment;
        this.mListItem = mListItem;
        this.mDefaultSpanCount = defaultSpanCount;

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return isHeaderType(position) ? mDefaultSpanCount : 1;
            }
        });
    }

    private boolean isHeaderType(int position) {
        return mListItem.get(position).getItemType() == Items.HEADER_ITEM_TYPE ? true : false;
    }

    @Override
    public HolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType==0){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_header, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_child, parent, false);
        }
        return new HolderHome(v);
    }

    @Override
    public void onBindViewHolder(HolderHome holder, int position) {
        if (isHeaderType(position)){
            binHeader(holder, position);
        } else {
            binChild(holder, position);
        }
    }

    private void binChild(HolderHome holder, final int position) {
        TextView tProdukName, tstoreName, tPrice;
        ImageView imgProd;

        tProdukName = (TextView) holder.itemView.findViewById(R.id.tProdukNameChild);
        tstoreName = (TextView) holder.itemView.findViewById(R.id.tStoreNameChild);
        tPrice = (TextView) holder.itemView.findViewById(R.id.tPriceChild);
        imgProd = (ImageView) holder.itemView.findViewById(R.id.imgProdChild);

        tProdukName.setText(mListItem.get(position).getProduct_name());
        tstoreName.setText(mListItem.get(position).getStore_name());
        tPrice.setText(mListItem.get(position).getProduct_price());

        if (imgCount == 0){
            imgProd.setImageResource(imgProduct[0]);
            imgCount++;
        } else if (imgCount == 1){
            imgProd.setImageResource(imgProduct[1]);
            imgCount++;
        } else {
            imgProd.setImageResource(imgProduct[2]);
            imgCount = 0;
        }

        imgProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalVariable.ProdNama = mListItem.get(position).getProduct_name();
                GlobalVariable.ProdToko = mListItem.get(position).getStore_name();
                GlobalVariable.ProdPrice = mListItem.get(position).getProduct_price();

                fragment.startActivity(new Intent(fragment.getActivity(), DetailProduct.class));
            }
        });
    }

    private void binHeader(HolderHome holder, int position) {
        ViewPager pager = (ViewPager) holder.itemView.findViewById(R.id.pagerHome);
        PagerAdapterHome pagerAdapterHome = new PagerAdapterHome(fragment.getFragmentManager());
        pager.setAdapter(pagerAdapterHome);
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mListItem.get(position).getItemType() == Items.HEADER_ITEM_TYPE ? 0:1;
    }


    public void addItem(Items item) {
        mListItem.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(Items items){
        mListItem.remove(items);
        notifyDataSetChanged();
    }
}
