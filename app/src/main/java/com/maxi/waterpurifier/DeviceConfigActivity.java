package com.maxi.waterpurifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxi.waterpurifier.base.BaseActivity;

public class DeviceConfigActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mRlIconDeviceLogo;
    private RelativeLayout mRlIconDeviceRecharge;
    private ImageView mIvBtnDeviceUnbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_config);

        RelativeLayout mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mHeadLayout.setBackgroundColor(getResources().getColor(R.color.maxi_head_main_color));
        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setImageResource(R.mipmap.btn_back2);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("系统设置");
        mTvHeader.setTextColor(getResources().getColor(R.color.white));

        mRlIconDeviceLogo = (RelativeLayout) findViewById(R.id.rl_icon_device_logo);
        mRlIconDeviceLogo.setOnClickListener(this);
        mRlIconDeviceRecharge = (RelativeLayout) findViewById(R.id.rl_icon_device_recharge);
        mRlIconDeviceRecharge.setOnClickListener(this);
        mIvBtnDeviceUnbind = (ImageView) findViewById(R.id.iv_btn_device_unbind);
        mIvBtnDeviceUnbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.rl_icon_device_logo:
                startActivity(new Intent(this, DeviceUpdateNameActivity.class));
                break;

            case R.id.rl_icon_device_recharge:
                startActivity(new Intent(this, DeviceRechargeActivity.class));
                break;

            case R.id.iv_btn_device_unbind:
                setResult(Activity.RESULT_OK, new Intent());
                finish();
                break;
        }
    }
}
