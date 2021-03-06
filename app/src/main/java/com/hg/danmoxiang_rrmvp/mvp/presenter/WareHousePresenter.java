package com.hg.danmoxiang_rrmvp.mvp.presenter;

import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;
import com.hg.danmoxiang_rrmvp.mvp.contract.WareHouseContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.BaseResponse;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;
import com.hg.danmoxiang_rrmvp.retrofit.ApiCallback;

import java.util.List;

public class WareHousePresenter extends BasePresenter<WareHouseContract> {
    public WareHousePresenter(WareHouseContract view) {
        attachView(view);
    }


    public void productInWH(String billCode, String json) {
        mvpView.showLoading();
        addSubscription(apiStores.requestProductInWareHouse("", billCode, json), new ApiCallback<BaseResponse>() {

            @Override
            public void onSuccess(BaseResponse model) {
                mvpView.showMsg(model.getMsg());
            }

            @Override
            public void onFailure(String msg) {
                mvpView.showMsg(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

    public void getMaterielByProductCode(String productCode) {
        mvpView.showLoading();
        addSubscription(apiStores.getMaterielByProductCode(productCode), new ApiCallback<BaseResponse<List<Materiel>>>() {

         /*  @Override
            public void onSuccess(BaseResponse model) {
                if (model.getResult().equals("1")) {
                    //ist<Link> materielList = (ArrayList<Materiel>) model.getData();

                   // mvpView.showMaterielInfo(materielList);
                } else {
                    mvpView.showError(model.getMsg());
                }
            }*/


            @Override
            public void onSuccess(BaseResponse<List<Materiel>> model) {
                if (model.getResult().equals("1")) {
                    mvpView.showMaterielInfo(model.getData());
                } else {
                    mvpView.showMsg(model.getMsg());
                }
            }

            @Override
            public void onFailure(String msg) {
                mvpView.showMsg(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

}
