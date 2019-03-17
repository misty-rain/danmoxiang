package com.hg.danmoxiang_rrmvp.mvp.presenter;

import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;

public class WareHousePresenter extends BasePresenter<BaseContract> {
    public WareHousePresenter(BaseContract view) {
        attachView(view);
    }

}
