package com.hg.danmoxiang_rrmvp.ui.activity.inventory;

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
import com.hg.danmoxiang_rrmvp.ui.adapter.InventoryMangeAdapter;
import com.hg.danmoxiang_rrmvp.ui.adapter.MainIconAdapter;
import com.hg.danmoxiang_rrmvp.ui.widget.ExtendGridView;
import com.hg.danmoxiang_rrmvp.utils.DataHelper;
import com.yyydjk.library.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InverntoryManageActivity extends MvpActivity<BasePresenter> implements BaseContract {

    @BindView(R.id.inventorygridview)
    ExtendGridView homeGridView;
    @BindView(R.id.banner)
    BannerLayout bannerLayout;
    List<String> imgUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventorymanger);
        initToolBarAsHome("库存管理");
        initData();

    }


    private void initData() {
        homeGridView.setAdapter(new InventoryMangeAdapter(this));
        homeGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        launchActivity(new Intent(InverntoryManageActivity.this, InventoryActivity.class));
                        break;
                    case 1:
                        launchActivity(new Intent(InverntoryManageActivity.this, InventorySearchActivity.class));
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
