package com.example.thebestone.thestores.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thebestone.thestores.R;

/**
 * Created by thebestone on 10/21/17.
 */

public class FragmentPict extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_iamge_viewer, container, false);

        return v;
    }
}
