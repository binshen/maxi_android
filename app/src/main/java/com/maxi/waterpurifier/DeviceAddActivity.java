package com.maxi.waterpurifier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxi.waterpurifier.base.BaseActivity;

public class DeviceAddActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEtWifiSid;
    private EditText mEtWifiPsw;

    private ImageView mIvBtnDeviceNext;

    private BroadcastReceiver mWifiChangedReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_add);

        RelativeLayout mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mHeadLayout.setBackgroundColor(getResources().getColor(R.color.maxi_head_main_color));
        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setImageResource(R.mipmap.btn_back2);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("设备配对");
        mTvHeader.setTextColor(getResources().getColor(R.color.white));

        mIvBtnDeviceNext = (ImageView) findViewById(R.id.iv_btn_device_next);
        mIvBtnDeviceNext.setOnClickListener(this);

        mEtWifiSid = (EditText) findViewById(R.id.et_wifi_sid);
        mEtWifiPsw = (EditText) findViewById(R.id.et_wifi_psw);

        mEtWifiSid.setText(getSSid());
        mWifiChangedReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                String ssid = getSSid();
                if (networkInfo != null && networkInfo.isConnected() && !ssid.equals("")) {
                    mEtWifiSid.setText(ssid);
                    mEtWifiPsw.requestFocus();
                    mIvBtnDeviceNext.setEnabled(true);
                } else {
                    mEtWifiSid.setText("");
                    mEtWifiSid.requestFocus();
                    mIvBtnDeviceNext.setEnabled(false);
                    if (mLoadDialog.isShowing()) {
                        mLoadDialog.dismiss();
                    }
                }
            }
        };
        registerReceiver(mWifiChangedReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private String getSSid(){

        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
        if(wm != null){
            WifiInfo wi = wm.getConnectionInfo();
            if(wi != null){
                String ssid = wi.getSSID();
                if(ssid.length() > 2 && ssid.startsWith("\"") && ssid.endsWith("\"")){
                    return ssid.substring(1, ssid.length() - 1);
                }else if(ssid.equals("<unknown ssid>")) {
                    return "";
                } else {
                    return ssid;
                }
            }
        }
        return "";
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.iv_btn_device_next:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(mWifiChangedReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
