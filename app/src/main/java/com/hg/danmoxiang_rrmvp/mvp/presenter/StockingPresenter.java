package com.hg.danmoxiang_rrmvp.mvp.presenter;

import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;

public class StockingPresenter extends BasePresenter<BaseContract> {
    public StockingPresenter(BaseContract view) {
        attachView(view);
    }

}
