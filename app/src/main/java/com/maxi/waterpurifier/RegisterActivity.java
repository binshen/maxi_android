package com.maxi.waterpurifier;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxi.waterpurifier.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("注册");
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
