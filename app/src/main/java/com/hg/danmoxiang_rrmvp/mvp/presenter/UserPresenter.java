package com.hg.danmoxiang_rrmvp.mvp.presenter;

import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.integration.AppManager;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;
import com.hg.danmoxiang_rrmvp.mvp.contract.LoginContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.BaseResponse;
import com.hg.danmoxiang_rrmvp.retrofit.ApiCallback;
import com.hg.danmoxiang_rrmvp.utils.DataHelper;

public class UserPresenter extends BasePresenter<LoginContract> {
    public UserPresenter(LoginContract view) {
        attachView(view);
    }

    public void login(String userName, String passWord) {
        mvpView.showLoading();
        addSubscription(apiStores.requestLogin(userName, passWord),
                  new ApiCallback<BaseResponse>() {
                      @Override
                      public void onSuccess(BaseResponse model) {
                          if (model.getResult().equals("1")) {
                              DataHelper.setStringSF(AppManager.getAppManager().getCurrentActivity(), SysConstants.LOCAL_IS_AUTO_LOGIN,"1");
                              mvpView.loginSuccess(model);
                          } else {
                              mvpView.loginFail(model.getMsg());
                          }
                      }

                      @Override
                      public void onFailure(String msg) {
                          mvpView.loginFail(msg);
                      }


                      @Override
                      public void onFinish() {
                          mvpView.hideLoading();
                      }
                  });
    }

    public void isAutoLogin() {
        if (DataHelper.getStringSF(AppManager.getAppManager().getCurrentActivity(),SysConstants.LOCAL_IS_AUTO_LOGIN).equals("1")) {
            mvpView.gotoHome();;
        }
    }

    public void checkLogin(String userName,String passWord) {
        mvpView.showLoading();
        addSubscription(apiStores.requestCheckLogin(userName),
                  new ApiCallback<BaseResponse>() {
                      @Override
                      public void onSuccess(BaseResponse model) {
                          if (model.getResult().equals("1")) {
                                  login(userName,passWord);

                          } else {
                              mvpView.loginFail(model.getMsg());
                          }

                      }

                      @Override
                      public void onFailure(String msg) {
                          mvpView.loginFail(msg);

                      }


                      @Override
                      public void onFinish() {
                          mvpView.hideLoading();
                      }
                  });
    }

    public void logout(String loginLogId) {
        addSubscription(apiStores.requestLogout(loginLogId), new ApiCallback() {
            @Override
            public void onSuccess(Object model) {

            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onFinish() {

            }
        });


    }
}
