package com.hg.danmoxiang_rrmvp.mvp.presenter;

import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;

public class InventoryPresenter extends BasePresenter<BaseContract> {
    public InventoryPresenter(BaseContract view) {
        attachView(view);
    }

}
