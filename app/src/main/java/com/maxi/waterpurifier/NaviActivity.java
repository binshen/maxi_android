package com.maxi.waterpurifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.maxi.waterpurifier.base.BaseActivity;

public class NaviActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBtnLogin;
    private ImageView mIvBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        mIvBtnLogin = (ImageView) findViewById(R.id.iv_btn_login);
        mIvBtnLogin.setOnClickListener(this);
        mIvBtnRegister = (ImageView) findViewById(R.id.iv_btn_register);
        mIvBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_btn_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.iv_btn_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}
