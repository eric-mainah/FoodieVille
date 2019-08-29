package com.example.foodieville2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterOrder extends BaseAdapter {
    Context mContext;
    ArrayList<Dishi>data;

    public CustomAdapterOrder(Context mContext, ArrayList<Dishi> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int pos) {
        return data.get(pos);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.custom_order_layout , viewGroup , false);
            viewHolder = new ViewHolder();
            viewHolder.mName = convertView.findViewById(R.id.nameTv);
            viewHolder.mFood = convertView.findViewById(R.id.foodTv);
            viewHolder.mDrink = convertView.findViewById(R.id.drinkTv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        Dishi info = data.get(pos);
        viewHolder.mName.setText(info.getJina());
        viewHolder.mFood.setText(info.getFfood());
        viewHolder.mDrink.setText(info.getDrink());

        return  convertView;
    }

    static class ViewHolder{
        TextView mName;
        TextView mFood;
        TextView mDrink;
    }
}
