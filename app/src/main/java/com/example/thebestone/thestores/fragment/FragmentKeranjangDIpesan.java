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

public class FragmentKeranjangDIpesan extends Fragment {

    ListViewAdapter adapter;
    List<CustomerModel> mList = new ArrayList<>();
    ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_selesainpesan, container, false);

        addData();

        adapter = new ListViewAdapter(getContext(), mList);

        mListView = (ListView) v.findViewById(R.id.listSelesai);
        mListView.setAdapter(adapter);

        return v;
    }

    private void addData() {
        mList.add(new CustomerModel("Nasi Padang", "09278409823"));
        mList.add(new CustomerModel("Jus Alpukat", "93749232434"));
    }
}
