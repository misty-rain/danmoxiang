package com.hg.danmoxiang_rrmvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;


public class WareHouseMenuAdapter extends BaseAdapter {
    private Context context;
    private int [] imgs = {R.mipmap.wh_product_in,R.mipmap.wh_product_out,R.mipmap.wh_purchaseorder_in,
              R.mipmap.wh_purchaseorder_out
    };
    private  String [] strs = {"产品入库","产品出库","采购单入库","销售订单出库"};


    public WareHouseMenuAdapter(Context context) {
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
        WareHouseMenuAdapter.ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.main_grid__item,parent,false);
            holder = new WareHouseMenuAdapter.ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.item_img);
            holder.textView = (TextView)convertView.findViewById(R.id.item_txt);
            convertView.setTag(holder);
        }else {
            holder = (WareHouseMenuAdapter.ViewHolder)convertView.getTag();
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
