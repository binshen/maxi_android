package com.maxi.waterpurifier;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maxi.waterpurifier.base.BaseActivity;
import com.maxi.waterpurifier.base.Constants;
import com.maxi.waterpurifier.base.Result;
import com.maxi.waterpurifier.base.ResultCallback;
import com.maxi.waterpurifier.model.User;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;

public class ForgetPwdActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvSendCode;
    private ImageView mIvBtnForgetPwd;

    private EditText mEtUsername;
    private EditText mEtPassword;
    private EditText mEtValidateCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);

        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("忘记密码");

        mEtUsername = (EditText)findViewById(R.id.et_username);
        mEtPassword = (EditText)findViewById(R.id.et_password);
        mEtValidateCode = (EditText)findViewById(R.id.et_validatecode);

        mIvSendCode = (ImageView) findViewById(R.id.iv_btn_send_code);
        mIvSendCode.setOnClickListener(this);
        mIvBtnForgetPwd = (ImageView) findViewById(R.id.iv_btn_forget_pwd);
        mIvBtnForgetPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String tel  = mEtUsername.getText().toString().trim();
        String code = mEtValidateCode.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();

        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.iv_btn_forget_pwd:
                if(TextUtils.isEmpty(tel)) {
                    Toast.makeText(getApplicationContext(), "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(code)) {
                    Toast.makeText(getApplicationContext(), "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                changePassword(tel, password, code);
                break;

            case R.id.iv_btn_send_code:
                if(TextUtils.isEmpty(tel)) {
                    Toast.makeText(getApplicationContext(), "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                sendMessage(tel);
                break;
        }
    }

    private void changePassword(String tel, String pwd, String code) {
        Map<String, String> params = new HashMap<>();
        params.put("tel", tel);
        params.put("password", pwd);
        params.put("code", code);
        OkHttpUtils.postString().url(Constants.FORGET_PASSWORD).content(new Gson().toJson(params))
                .mediaType(MediaType.parse("application/json; charset=utf-8")).build().execute(new ResultCallback<User>() {

            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getApplicationContext(), Constants.IS_DEBUG_MODE ? e.toString() : "网络故障，请稍候重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Result<User> response, int id) {
                application.loginUser = response.getContent();
                int code = response.getCode();
                if(code > 0) {
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), response.getError(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendMessage(String tel) {
        Map<String, String> params = new HashMap<>();
        params.put("tel", tel);
        OkHttpUtils.postString().url(Constants.REQUEST_CODE).content(new Gson().toJson(params))
                .mediaType(MediaType.parse("application/json; charset=utf-8")).build().execute(new ResultCallback<User>() {

            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getApplicationContext(), Constants.IS_DEBUG_MODE ? e.toString() : "网络故障，请稍候重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Result<User> response, int id) {
                application.loginUser = response.getContent();
                int code = response.getCode();
                if(code > 0) {
                    //TODO
                } else {
                    Toast.makeText(getApplicationContext(), response.getError(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
