package com.hg.danmoxiang_rrmvp.ui.activity.stocking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.BaseContract;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.presenter.StockingPresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class StockingActivity extends MvpActivity<StockingPresenter> implements BaseContract {



    @BindView(R.id.edtstockingunitcode)
    EditText edtUnitCode;
    @BindView(R.id.edtstockingoutcount)
    EditText edtOutCount;
    @BindView(R.id.edtinputscanncode)
    EditText edtInputScannCode;
    @BindView(R.id.edtcodecount)
    EditText edtCodeCount;
    @BindView(R.id.imgscann)
    ImageView imgScann;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocking);
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
                edtUnitCode.setText(resultStr);

            }
        }
    }

    @Override
    protected StockingPresenter createPresenter() {
        return new StockingPresenter(this);
    }


}
