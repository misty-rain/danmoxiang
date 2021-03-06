package com.hg.danmoxiang_rrmvp.ui.activity.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.presenter.InventoryPresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class InventoryActivity extends MvpActivity<InventoryPresenter> implements BaseContract {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        initToolBarAsHome("库存盘点");
    }

    @OnClick({R.id.imgscann})
    public void goSannQrCode() {
        startActivityForResult(new Intent(this, ScanningActivity.class), SysConstants.REQUEST_CODE_SCANN_QR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SysConstants.REQUEST_CODE_SCANN_QR_CODE) {
            if (null != data) {
                String resultStr = data.getStringExtra("resultStr");
               // edtScann.setText(resultStr);

            }
        }
    }

    @Override
    protected InventoryPresenter createPresenter() {
        return new InventoryPresenter(this);
    }


}
