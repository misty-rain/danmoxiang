package com.hg.danmoxiang_rrmvp.ui.activity.productform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.BasePresenter;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.DatePickerActivity;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 要货单
 */
public class ProductFormActivity extends MvpActivity<BasePresenter> implements BaseContract {


    @BindView(R.id.imgscann)
    ImageView imgScann;
    @BindView(R.id.edtdatepick)
    TextView edtDatePick;
    @BindView(R.id.edtpurchaseordernumber)
    EditText edtOrderNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productform);
        initToolBarAsHome("要货单");
    }

    @OnClick(R.id.imgscann)
    public void goSannQrCode() {
        startActivityForResult(new Intent(this, ScanningActivity.class), SysConstants.REQUEST_CODE_SCANN_QR_CODE);
    }

    @OnClick(R.id.edtdatepick)
    public void goDatePicker() {
        startActivityForResult(new Intent(this, DatePickerActivity.class), SysConstants.REQUEST_CODE_DATEPICK_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null == data)
            return;
        String resultStr = "";
        switch (requestCode) {
            case SysConstants.REQUEST_CODE_SCANN_QR_CODE:
                 resultStr = data.getStringExtra("resultStr");
                edtOrderNum.setText(resultStr);
                break;
            case SysConstants.REQUEST_CODE_DATEPICK_CODE:
                 resultStr = data.getStringExtra("resultStr");
                edtDatePick.setText(resultStr);
                break;
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
