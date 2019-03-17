package com.hg.danmoxiang_rrmvp.ui.activity.setting;

import android.os.Bundle;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.presenter.SettingPresenter;

public class SettingActivity extends MvpActivity<SettingPresenter> implements BaseContract {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initToolBarAsHome("设置");

    }


    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter(this);
    }


}
