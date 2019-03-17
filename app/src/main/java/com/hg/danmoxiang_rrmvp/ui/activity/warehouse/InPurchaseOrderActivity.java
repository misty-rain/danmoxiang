package com.hg.danmoxiang_rrmvp.ui.activity.warehouse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.presenter.WareHousePresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;
import com.hg.danmoxiang_rrmvp.ui.widget.SmoothCheckBox;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.OnClick;

public class InPurchaseOrderActivity extends MvpActivity<WareHousePresenter> implements BaseContract {

    @BindView(R.id.toolbar_title)
    TextView txtTitle;
    @BindView(R.id.edtcodecount)
    TextView edtCodeCount;
    @BindView(R.id.edtgetcompany)
    EditText edtGetCompanyName;
    @BindView(R.id.edtmaterielcode)
    EditText edtMaterileCode;
    @BindView(R.id.edtpurchaseordernumber)
    EditText edtPurchaseOrderNumber;
    @BindView(R.id.edtgetcount)
    EditText edtGetCount;
    @BindView(R.id.imgscann)
    ImageView imgScann;
    @BindView(R.id.switch_button)
    SwitchButton switchButton;
    @BindView(R.id.btnsave)
    Button btnSave;
    @BindView(R.id.btnscansearch)
    Button btnScannSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_purchase_order);
        initToolBarAsHome("采购单入库");
    }

    @OnClick(R.id.imgscann)
    public void goSannQrCode() {
        startActivityForResult(new Intent(this, ScanningActivity.class), SysConstants.REQUEST_CODE_SCANN_QR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SysConstants.REQUEST_CODE_SCANN_QR_CODE) {
            if (null != data) {
                String resultStr = data.getStringExtra("resultStr");
                edtPurchaseOrderNumber.setText(resultStr);
            }
        }
    }

    @Override
    protected WareHousePresenter createPresenter() {
        return new WareHousePresenter(this);
    }


}
