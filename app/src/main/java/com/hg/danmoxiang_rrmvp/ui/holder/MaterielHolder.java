package com.hg.danmoxiang_rrmvp.ui.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;

import butterknife.BindView;

public class MaterielHolder extends BaseHolder<Materiel> {
    @BindView(R.id.txtcode)
    TextView txtCode;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtModel)
    TextView txtModel;
    @BindView(R.id.txtcount)
    TextView txtCount;
    @BindView(R.id.txtlocation)
    TextView txtLocation;
    @BindView(R.id.btnDelete)
    Button btnDelete;

    public MaterielHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setData(@NonNull Materiel data, int position) {
        txtCode.setText(data.getProductCode());
        txtCount.setText("1");
        txtName.setText(data.getProductCName());
        txtModel.setText(data.getState());
        txtLocation.setText(data.getState());
    }
}
