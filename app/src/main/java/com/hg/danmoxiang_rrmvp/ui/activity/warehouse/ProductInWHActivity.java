package com.hg.danmoxiang_rrmvp.ui.activity.warehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.mvp.base.MvpActivity;
import com.hg.danmoxiang_rrmvp.mvp.contract.WareHouseContract;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;
import com.hg.danmoxiang_rrmvp.mvp.presenter.WareHousePresenter;
import com.hg.danmoxiang_rrmvp.ui.activity.ScanningActivity;
import com.hg.danmoxiang_rrmvp.ui.adapter.MaterielAdapter;
import com.hg.danmoxiang_rrmvp.utils.DeviceUtils;
import com.suke.widget.SwitchButton;
import com.wuxiaolong.androidutils.library.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnFocusChange;

public class ProductInWHActivity extends MvpActivity<WareHousePresenter> implements WareHouseContract {


    @BindView(R.id.toolbar_title)
    TextView txtTitle;
    @BindView(R.id.edtcodecount)
    TextView edtCodeCount;
    @BindView(R.id.edtgetcompany)
    EditText edtGetCompanyName;
    @BindView(R.id.edtmaterielcode)
    EditText edtMaterileCode;
    @BindView(R.id.edtinwhcode)
    EditText edtInWareHouseCode;
    @BindView(R.id.edtgetcount)
    EditText edtGetCount;
    @BindView(R.id.imgscann)
    ImageView imgScann;
    @BindView(R.id.switch_button)
    SwitchButton switchButton;
    @BindView(R.id.btnsave)
    Button btnSave;
    @BindView(R.id.rlmasteriellist)
    RecyclerView recyclerView;
    @BindView(R.id.showmaterieldata)
    View showmaterieldataView;
     @BindView(R.id.imglocationscan)
     ImageView imgLocationScan;
     @BindView(R.id.imgmaterielscan)
     ImageView imgMaterielScann;



    List<Materiel> mMaterielList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_in_wh);
        initToolBarAsHome("产品入库");
    }

    @OnClick(R.id.imgscann)
    public void goSannQrCode() {
        startActivityForResult(new Intent(this, ScanningActivity.class), SysConstants.REQUEST_CODE_SCANN_QR_CODE);
    }

    @OnFocusChange(R.id.edtmaterielcode)
    public void getMaterielInfoByCode() {
        DeviceUtils.hideSoftKeyboard(this, edtMaterileCode);
        if (!TextUtils.isEmpty(edtMaterileCode.getEditableText().toString()))
            mvpPresenter.getMaterielByProductCode(edtMaterileCode.getEditableText().toString());
    }

    @OnClick(R.id.btnsave)
    public void submitProductData() {
        validateForm();
    }

    private void validateForm() {
        if (TextUtils.isEmpty(edtGetCompanyName.getEditableText())) {
            toastShow(R.string.input_get_company);
            return;
        }

        if (TextUtils.isEmpty(edtMaterileCode.getEditableText())) {
            toastShow(R.string.input_materiel_code);
            return;
        }

        if (null == mMaterielList || mMaterielList.size() == 0){
            toastShow(R.string.text_input_materiel_data);
            return;
        }

        Materiel materiel =  mMaterielList.get(0);
        String json = new Gson().toJson(materiel);
        LogUtil.d("materiel json:" + json);
        mvpPresenter.productInWH(TextUtils.isEmpty(edtInWareHouseCode.getEditableText()) ? "" : edtInWareHouseCode.getEditableText().toString(), json);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SysConstants.REQUEST_CODE_SCANN_QR_CODE) {
            if (null != data) {
                String resultStr = data.getStringExtra("resultStr");
                edtInWareHouseCode.setText(resultStr);
            }
        }
    }

    @Override
    protected WareHousePresenter createPresenter() {
        return new WareHousePresenter(this);
    }


    @Override
    public void showMaterielInfo(List<Materiel> materielsList) {
        if (null != materielsList) {
            mMaterielList = materielsList;
            showmaterieldataView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(new MaterielAdapter(materielsList, showmaterieldataView));
        }
    }

    @Override
    public void showMsg(String msg) {
        showmaterieldataView.setVisibility(View.GONE);
        toastShow(msg);
    }
}
