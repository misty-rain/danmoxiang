package com.hg.danmoxiang_rrmvp.ui.activity.warehouse;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.contract.WareHouseContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;
import com.hg.danmoxiang_rrmvp.mvp.presenter.WareHousePresenter;
import com.suke.widget.SwitchButton;

import java.util.List;

import butterknife.BindView;

public class OutSalesOrderActivity extends MvpActivity<WareHousePresenter> implements WareHouseContract {


    @BindView(R.id.edtsalesordernumber)
    EditText edtSalesOrderOutNumber;
    @BindView(R.id.edtcodecount)
    TextView edtCodeCount;
    @BindView(R.id.edtoutcompany)
    EditText edtOutCompanyName;
    @BindView(R.id.edtoutcount)
    EditText edtOutCount;
    @BindView(R.id.imgscannout)
    ImageView imgScannOut;
    @BindView(R.id.imglocationscan)
    ImageView imgLcationScan;
    @BindView(R.id.imgscanncode)
    ImageView imgScannCode;
    @BindView(R.id.switch_button)
    SwitchButton switchButton;
    @BindView(R.id.btnsave)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_sales_order);
        initToolBarAsHome("销售订单出库");
    }

    @Override
    protected WareHousePresenter createPresenter() {
        return new WareHousePresenter(this);
    }


    @Override
    public void showMaterielInfo(List<Materiel> materiel) {

    }
}
