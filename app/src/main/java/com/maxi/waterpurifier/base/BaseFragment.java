package com.maxi.waterpurifier.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.maxi.waterpurifier.widget.LoadDialog;

/**
 * Created by bin.shen on 21/12/2016.
 */

public class BaseFragment extends Fragment {

    protected LoadDialog mLoadDialog;

    protected BaseApplication application;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLoadDialog = new LoadDialog(getContext());
        application = (BaseApplication) getActivity().getApplication();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        mLoadDialog.dismiss();
        super.onPause();
    }
}
