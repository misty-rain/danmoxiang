package com.hg.danmoxiang_rrmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.GlideImageLoader;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.auth.LoginActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.inventory.InventorySearchActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.inventory.InverntoryManageActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.productform.ProductFormActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.productform.ProductFormMangeActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.setting.SettingActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.stocking.StockingActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.warehouse.WareHouseActivity;
import com.hg.danmoxiang_rrmvp.ui.adapter.MainIconAdapter;
import com.hg.danmoxiang_rrmvp.ui.widget.ExtendGridView;
import com.hg.danmoxiang_rrmvp.utils.DataHelper;
import com.yyydjk.library.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeActivity extends MvpActivity<BasePresenter> implements BaseContract {


    @BindView(R.id.homegridview)
    ExtendGridView homeGridView;
    @BindView(R.id.banner)
    BannerLayout bannerLayout;
    List<String> imgUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initData();

    }

    private void initData() {
        homeGridView.setAdapter(new MainIconAdapter(this));
        homeGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        launchActivity(new Intent(HomeActivity.this, WareHouseActivity.class));
                        break;
                    case 1:
                        launchActivity(new Intent(HomeActivity.this, ProductFormMangeActivity.class));
                        break;
                    case 2:
                        launchActivity(new Intent(HomeActivity.this, InverntoryManageActivity.class));
                        break;
                    case 3:
                        launchActivity(new Intent(HomeActivity.this, SettingActivity.class));
                        break;
                    case 4:
                        DataHelper.setStringSF(mActivity, SysConstants.LOCAL_IS_AUTO_LOGIN,"");
                        launchActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();
                        break;
                }

            }
        });
        imgUrls.add("http://www.hgtm.cn/images/qq1.jpg");
        imgUrls.add("http://www.hgtm.cn/images/qq2.jpg");
        imgUrls.add("http://www.hgtm.cn/images/qq3.jpg");

        bannerLayout.setImageLoader(new GlideImageLoader());
        bannerLayout.setViewUrls(imgUrls);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
