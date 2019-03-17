package com.hg.danmoxiang_rrmvp.ui.activity.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.contract.LoginContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.BaseResponse;
import com.hg.danmoxiang_rrmvp.mvp.presenter.UserPresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends MvpActivity<UserPresenter> implements LoginContract {



    @BindView(R.id.btnlogin)
    Button btnLogin;
    @BindView(R.id.edtTxtName)
    EditText edtUserName;
    @BindView(R.id.edtTxtPwd)
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mvpPresenter.isAutoLogin();

    }

    @Override
    protected UserPresenter createPresenter() {
        return new UserPresenter(this);
    }

    @OnClick(R.id.btnlogin)
    public void login() {
        mvpPresenter.checkLogin(edtUserName.getEditableText().toString(),edtPassword.getText().toString());
    }

    @Override
    public void loginSuccess(BaseResponse baseResponse) {
        launchActivity(new Intent(this, HomeActivity.class));
        finish();

    }

    @Override
    public void loginFail(String msg) {
        toastShow(msg);
    }

    @Override
    public void gotoHome() {
        launchActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
