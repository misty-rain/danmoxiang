package com.hg.danmoxiang_rrmvp.mvp.contract;

import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.BaseResponse;

public interface LoginContract extends BaseContract {

    void loginSuccess(BaseResponse baseResponse);

    void loginFail(String msg);

    void gotoHome();


}
