package com.maxi.waterpurifier.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxi.waterpurifier.R;
import com.maxi.waterpurifier.base.BaseFragment;

public class FilterStatusFragment extends BaseFragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filter_status, container, false);
        return view;
    }

}
