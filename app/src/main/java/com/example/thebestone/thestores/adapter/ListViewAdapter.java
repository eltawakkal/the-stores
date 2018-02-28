package com.example.thebestone.thestores.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.model.CustomerModel;

import java.util.List;

import static android.R.attr.resource;

/**
 * Created by thebestone on 10/18/17.
 */

public class ListViewAdapter extends ArrayAdapter<CustomerModel> {

    List<CustomerModel> mList;

    public ListViewAdapter(Context context, List<CustomerModel> resource) {
        super(context, R.layout.cutom_list_cust, resource);
        this.mList = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cutom_list_cust, parent, false);

        TextView prodName, storeName;

        prodName = (TextView) view.findViewById(R.id.titleListCust);
        storeName = (TextView) view.findViewById(R.id.subtitleListCust);

        prodName.setText(mList.get(position).getNama());
        storeName.setText(mList.get(position).getNotelp());

        return view;
    }
}
