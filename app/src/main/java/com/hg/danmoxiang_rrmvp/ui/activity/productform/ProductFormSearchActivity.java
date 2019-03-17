package com.hg.danmoxiang_rrmvp.ui.activity.productform;

import android.os.Bundle;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;

/**
 * 要货单
 */
public class ProductFormSearchActivity extends MvpActivity<BasePresenter> implements BaseContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productform);
        initToolBarAsHome("要货单查询");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
