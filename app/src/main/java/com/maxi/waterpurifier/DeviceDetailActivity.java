package com.maxi.waterpurifier;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maxi.waterpurifier.base.BaseActivity;

public class DeviceDetailActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRgDeviceGroup;
    private RadioButton mRbBtnFilterStatus;
    private RadioButton mRbBtnWaterYield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        RelativeLayout mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mHeadLayout.setBackgroundColor(getResources().getColor(R.color.maxi_head_main_color));
        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setImageResource(R.mipmap.btn_back2);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("淼溪净水");
        mTvHeader.setTextColor(getResources().getColor(R.color.white));
        ImageView btn_head_right = (ImageView) findViewById(R.id.btn_head_right);
        btn_head_right.setImageResource(R.mipmap.icon_device_config);
        btn_head_right.setOnClickListener(this);

        mRgDeviceGroup = (RadioGroup) findViewById(R.id.rg_device_group);
        mRgDeviceGroup.setOnCheckedChangeListener(this);

        mRbBtnFilterStatus = (RadioButton) findViewById(R.id.rb_btn_filter_status);
        mRbBtnWaterYield = (RadioButton) findViewById(R.id.rb_btn_water_yield);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.btn_head_right:
                startActivity(new Intent(this, DeviceConfigActivity.class));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        Drawable drawable = getResources().getDrawable(R.drawable.bg_underline);
        //drawable.setBounds(0, 0, 100, 10);
        switch (checkedId) {
            case R.id.rb_btn_filter_status:
                mRbBtnFilterStatus.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                mRbBtnWaterYield.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                break;

            case R.id.rb_btn_water_yield:
                mRbBtnFilterStatus.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                mRbBtnWaterYield.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                break;
        }
    }
}
