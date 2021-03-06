package com.hg.danmoxiang_rrmvp.retrofit;


import com.hg.danmoxiang_rrmvp.mvp.model.entity.BaseResponse;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://106.14.41.22:43018/Api/";

    // 用户模块
    //登陆
    @GET("Login/CheckUserName")
    Observable<BaseResponse> requestLogin(@Query("loginName") String loginName, @Query("Password") String Password);
    //检查是否已登陆
    @GET("Login/CheckLogin")
    Observable<BaseResponse> requestCheckLogin(@Query("loginName") String loginName);
    //注销
    @GET("/Login/Exit")
    Observable<BaseResponse> requestLogout(@Query("LoginLogId") String loginLogID);

    //物料模块
    @GET("Product/GetProductAll")
    Observable<List<Materiel>> getMaterielList();
    @GET("Product/GetProductByProductCode")
    Observable<BaseResponse<List<Materiel>>> getMaterielByProductCode(@Query("ProductCode") String productCode);
    @GET("Product/GetProductByProductId")
    Observable<BaseResponse> getMaterielByProductId(@Query("ProductId") String productId);

    //产品入库
    @POST("/Business/SaveWareHouseIn")
    Observable<BaseResponse> requestProductInWareHouse(@Query("loginName") String loginName,@Query("BillCode") String billCode,@Query("WareHouseInjsonString") String inJson);



}
