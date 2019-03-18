package com.hg.danmoxiang_rrmvp.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;
import com.hg.danmoxiang_rrmvp.ui.base.BaseAdapter;
import com.hg.danmoxiang_rrmvp.ui.holder.BaseHolder;
import com.hg.danmoxiang_rrmvp.ui.holder.MaterielHolder;

import java.util.List;

public class MaterielAdapter extends BaseAdapter<Materiel> {


    public MaterielAdapter(List<Materiel> list) {
        super(list);
    }

    @NonNull
    @Override
    public BaseHolder<Materiel> getHolder(@NonNull View v, int viewType) {
        return new MaterielHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.activity_masteriel_item;
    }

 /*   @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                  .inflate(R.layout.activity_masteriel_item, viewGroup, false);
        return new MaterielHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
         MaterielHolder materielHolder = (MaterielHolder) viewHolder;
         materielHolder.setData(materielList.get(0),i);
    }*/


}
