package com.cheese.haircutconnect.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import com.cheese.haircutconnect.R;
import com.cheese.haircutconnect.base.BaseActivity;
import com.cheese.haircutconnect.param.UrlParam;
import com.cheese.haircutconnect.tools.MD5Utils;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class LoginActivity extends BaseActivity
{
    @BindView(R.id.et_login_account)
    MaterialEditText etAccount;
    @BindView(R.id.et_login_password)
    MaterialEditText etPassword;
    @BindView(R.id.tv_login_forget)
    TextView tvForget;
    @BindView(R.id.tv_login_register)
    TextView tvRegister;
    @BindView(R.id.fab_login)
    FloatingActionButton fabLogin;

    @Override
    protected int initLayoutId()
    {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitLogic(Bundle savedInstanceState)
    {
        tvForget.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvForget.getPaint().setAntiAlias(true);
        tvRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvRegister.getPaint().setAntiAlias(true);
    }

    @OnClick(R.id.fab_login)
    public void login()
    {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                LoginActivity.this, fabLogin, "intoMainActivity").toBundle());
    }

    @OnClick(R.id.tv_login_register)
    public void loginRegister()
    {

    }

    @OnClick(R.id.tv_login_forget)
    public void loginForget()
    {

    }

    private void loginLogic()
    {
        OkHttpUtils
                .get()
                .url(UrlParam.URL_USER_LOGIN)
                .addParams("account", etAccount.getText().toString())
                .addParams("password", MD5Utils.getMD5(etPassword.getText().toString()))
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                    }

                    @Override
                    public void onResponse(String response, int id)
                    {
                    }
                });
    }
}
