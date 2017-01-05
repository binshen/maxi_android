package com.maxi.waterpurifier;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxi.waterpurifier.base.BaseActivity;

public class DeviceUpdateNameActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_update_name);

        RelativeLayout mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mHeadLayout.setBackgroundColor(getResources().getColor(R.color.maxi_head_main_color));
        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setImageResource(R.mipmap.btn_back2);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("修改名字");
        mTvHeader.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;
        }
    }
}
