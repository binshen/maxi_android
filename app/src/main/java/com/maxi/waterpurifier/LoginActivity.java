package com.maxi.waterpurifier;

import android.content.Intent;
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
import com.maxi.waterpurifier.utils.Validator;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBtnLogin;
    private TextView mTvBtnForgetPwd;

    private EditText mEtUsername;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("登录");

        mEtUsername = (EditText)findViewById(R.id.et_username);
        mEtPassword = (EditText)findViewById(R.id.et_password);

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
                String username = mEtUsername.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                if(TextUtils.isEmpty(username)) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Validator.isMobile(username)) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                login(username, password);
                break;

            case R.id.tv_btn_forget_pwd:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
        }
    }

    public void login(final String tel, final String pwd) {
        mLoadDialog.show();

        Map<String, String> params = new HashMap<>();
        params.put("tel", tel);
        params.put("password", pwd);
        OkHttpUtils.postString().url(Constants.LOGIN).content(new Gson().toJson(params))
                .mediaType(MediaType.parse("application/json; charset=utf-8")).build().execute(new ResultCallback<User>() {

            @Override
            public void onError(Call call, Exception e, int id) {
                Toast.makeText(getApplicationContext(), Constants.IS_DEBUG_MODE ? e.toString() : "网络故障，请稍候重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Result<User> response, int id) {
                application.loginUser = response.getContent();
                int code = response.getCode();
                if(code < 0) {
                    Toast.makeText(getApplicationContext(), response.getError(), Toast.LENGTH_SHORT).show();
                    if (mLoadDialog.isShowing()) {
                        mLoadDialog.dismiss();
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
}
