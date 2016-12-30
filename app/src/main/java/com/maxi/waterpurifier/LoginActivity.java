package com.maxi.waterpurifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxi.waterpurifier.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBtnLogin;
    private TextView mTvBtnForgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("登录");

        mIvBtnLogin = (ImageView) findViewById(R.id.iv_btn_login);
        mIvBtnLogin.setOnClickListener(this);
        mTvBtnForgetPwd = (TextView) findViewById(R.id.tv_btn_forget_pwd);
        mTvBtnForgetPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.iv_btn_login:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.tv_btn_forget_pwd:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
        }
    }
}
