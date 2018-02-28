package com.example.thebestone.thestores.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.thebestone.thestores.R;
import com.example.thebestone.thestores.adapter.ListViewAdapter;
import com.example.thebestone.thestores.model.CustomerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thebestone on 10/8/17.
 */

public class FragmentKeranjangSelesai extends Fragment {

    List<CustomerModel> mData;
    ListView mList;
    ListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_selesainpesan, container, false);

        mData = new ArrayList<>();
        addData();

        adapter = new ListViewAdapter(getContext(), mData);
        mList = (ListView) v.findViewById(R.id.listSelesai);
        mList.setAdapter(adapter);

        return v;
    }

    private void addData() {
        mData.add(new CustomerModel("Kripik Sambe", "2423432434"));
        mData.add(new CustomerModel("Serbuk Tempe", "0813121245"));
        mData.add(new CustomerModel("Jambu Mente", "43524343"));
        mData.add(new CustomerModel("Kopi Serbuk Asli", "23423423"));
    }
}
