package com.hg.danmoxiang_rrmvp.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.mvp.model.entity.Materiel;
import com.hg.danmoxiang_rrmvp.ui.base.BaseAdapter;
import com.hg.danmoxiang_rrmvp.ui.holder.BaseHolder;
import com.hg.danmoxiang_rrmvp.ui.holder.MaterielHolder;

import java.util.List;

public class MaterielAdapter extends BaseAdapter<Materiel>  {

    List<Materiel> materielList;
    View dataView;

    public MaterielAdapter(List<Materiel> list,View view) {
        super(list);
        materielList = list;
        dataView = view;
    }

    @NonNull
    @Override
    public BaseHolder<Materiel> getHolder(@NonNull View v, int viewType) {
        return new MaterielHolder(v);
    }
    /**
     * 绑定数据
     *
     * @param holder   {@link BaseHolder}
     * @param position 在 RecyclerView 中的位置
     */
    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.setData(mInfos.get(position), position);
        Button btnDelete = holder.itemView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeData(position);
            }
        });

    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.activity_masteriel_item;
    }


        //  添加数据
    public void addData(int position) {
        //添加动画
        notifyItemInserted(position);
    }
    //  删除数据
    public void removeData(int position) {
        materielList.remove(position);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();
        if (materielList.size() == 0)
            dataView.setVisibility(View.GONE);
    }

}
