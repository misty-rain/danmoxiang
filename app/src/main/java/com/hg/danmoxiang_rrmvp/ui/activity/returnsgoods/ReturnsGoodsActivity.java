package com.hg.danmoxiang_rrmvp.ui.activity.returnsgoods;

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
import com.hg.danmoxiang_rrmvp.mvp.presenter.ReturnsPresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;
import com.hg.danmoxiang_rrmvp.ui.widget.SmoothCheckBox;

import butterknife.BindView;
import butterknife.OnClick;

public class ReturnsGoodsActivity extends MvpActivity<ReturnsPresenter> implements BaseContract {

    @BindView(R.id.toolbar_title)
    TextView txtTitle;
    @BindView(R.id.edtcodecount)
    EditText edtCodeCount;
    @BindView(R.id.edtreturngoodsunitcode)
    EditText edtUnitCompanyName;
    @BindView(R.id.edtmaterielcode)
    EditText edtMaterielCode;
    @BindView(R.id.edtreturnsgoodscount)
    EditText edtReturnsGoodsCount;
    @BindView(R.id.imgscannreturns)
    ImageView imgScannReturns;
    @BindView(R.id.imgscann)
    ImageView imgScannCustomer;
    @BindView(R.id.chkSerializable)
    SmoothCheckBox chkSerializable;
    @BindView(R.id.btnsave)
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returned_goods);
        initToolBarAsHome("销售退货");
    }

    @OnClick({R.id.imgscannreturns})
    public void goSannQrCode() {
        startActivityForResult(new Intent(this, ScanningActivity.class), SysConstants.REQUEST_CODE_SCANN_QR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SysConstants.REQUEST_CODE_SCANN_QR_CODE) {
            if (null != data) {
                String resultStr = data.getStringExtra("resultStr");
                edtReturnsGoodsCount.setText(resultStr);

            }
        }
    }


    @Override
    protected ReturnsPresenter createPresenter() {
        return new ReturnsPresenter(this);
    }


}
