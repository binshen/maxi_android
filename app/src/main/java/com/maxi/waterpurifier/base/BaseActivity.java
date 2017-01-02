package com.maxi.waterpurifier.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by bin.shen on 21/12/2016.
 */

public class BaseActivity extends FragmentActivity {

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
