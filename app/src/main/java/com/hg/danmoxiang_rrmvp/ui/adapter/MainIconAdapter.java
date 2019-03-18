package com.hg.danmoxiang_rrmvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.danmoxiang_rrmvp.R;


public class MainIconAdapter extends BaseAdapter{
    private Context context;
    private int [] imgs = {R.mipmap.main_icon_in_out_manager,R.mipmap.main_icon_form_manager,R.mipmap.main_icon_inventory_manager
              ,R.mipmap.main_icon_setting,R.mipmap.main_icon_logout
    };
    private  String [] strs = {"出入库管理","要货单管理","库存管理","设置","退出"};


    public MainIconAdapter(Context context) {
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
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.main_grid__item,parent,false);
            holder = new ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.item_img);
            holder.textView = (TextView)convertView.findViewById(R.id.item_txt);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
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
