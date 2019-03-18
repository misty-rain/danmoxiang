package com.hg.danmoxiang_rrmvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;

public class InventoryMangeAdapter extends BaseAdapter {
    private Context context;
    private int [] imgs = {R.mipmap.inventory_icon,R.mipmap.inventory_seach_icon
    };
    private  String [] strs = {"库存盘点","库存查询"};


    public InventoryMangeAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InventoryMangeAdapter.ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.main_grid__item,parent,false);
            holder = new InventoryMangeAdapter.ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.item_img);
            holder.textView = (TextView)convertView.findViewById(R.id.item_txt);
            convertView.setTag(holder);
        }else {
            holder = (InventoryMangeAdapter.ViewHolder)convertView.getTag();
        }
        holder.imageView.setBackgroundResource(imgs[position]);
        holder.textView.setText(strs[position]);

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
