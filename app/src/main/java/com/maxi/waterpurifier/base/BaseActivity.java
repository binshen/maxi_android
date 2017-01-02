package com.maxi.waterpurifier.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.maxi.waterpurifier.widget.LoadDialog;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by bin.shen on 21/12/2016.
 */

public class BaseActivity extends FragmentActivity {

    protected LoadDialog mLoadDialog;

    protected BaseApplication application;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        mLoadDialog = new LoadDialog(this);
        application = (BaseApplication) getApplication();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        mLoadDialog.dismiss();
        super.onPause();
    }
}
