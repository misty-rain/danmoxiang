package com.hg.danmoxiang_rrmvp.ui.activity.warehouse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.contract.WareHouseContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;
import com.hg.danmoxiang_rrmvp.mvp.presenter.WareHousePresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;
import com.suke.widget.SwitchButton;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ProductOutWHActivity extends MvpActivity<WareHousePresenter> implements WareHouseContract {

    @BindView(R.id.toolbar_title)
    TextView txtTitle;
    @BindView(R.id.edtcodecount)
    TextView edtCodeCount;
    @BindView(R.id.edtoutcompany)
    EditText edtOutCompanyName;
    @BindView(R.id.edtoutcustomercode)
    EditText edtCustomerCode;
    @BindView(R.id.edtoutwhcode)
    EditText edtOutWareHouseCode;
    @BindView(R.id.edtoutcount)
    EditText edtOutCount;
    @BindView(R.id.imgscannout)
    ImageView imgScannOut;
    @BindView(R.id.imgscanncustomer)
    ImageView imgScannCustomer;
    @BindView(R.id.switch_button)
    SwitchButton switchButton;
    @BindView(R.id.btnsave)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_out_wh);
        initToolBarAsHome("产品出库");
    }

    @OnClick({R.id.imgscannout})
    public void goSannQrCode() {
        startActivityForResult(new Intent(this, ScanningActivity.class), SysConstants.REQUEST_CODE_SCANN_QR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SysConstants.REQUEST_CODE_SCANN_QR_CODE) {
            if (null != data) {
                String resultStr = data.getStringExtra("resultStr");
                edtOutWareHouseCode.setText(resultStr);

            }
        }
    }

    @Override
    protected WareHousePresenter createPresenter() {
        return new WareHousePresenter(this);
    }


    @Override
    public void showMaterielInfo(List<Materiel> materiel) {

    }
}
