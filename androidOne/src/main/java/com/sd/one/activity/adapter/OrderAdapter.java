package com.sd.one.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sd.one.R;
import com.sd.one.utils.db.entity.Order;


/**
 * [我的订单 适配器]
 *
 * @author zhouyuandong
 * @version 1.0
 * @date 2016-5-4
 *
 **/
public class OrderAdapter extends BaseAdapter<Order> {

    private ViewHolder holder;

    /**
     * @param context
     */
    public OrderAdapter(Context context) {
        super(context);
    }

    class ViewHolder {
        ImageView item_avater_img;
        TextView item_name;
        TextView level;
        TextView item_price;
        TextView item_desc;
        TextView item_status;
        TextView item_time;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.order_item_layout, null);
            holder.item_avater_img = getViewById(convertView, R.id.item_avater_img);
            holder.item_name = getViewById(convertView, R.id.item_name);
            holder.item_desc = getViewById(convertView, R.id.item_desc);
            holder.item_status = getViewById(convertView, R.id.item_status);
            holder.item_price = getViewById(convertView, R.id.item_price);
            holder.item_time = getViewById(convertView, R.id.item_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Order bean = dataSet.get(position);
        holder.item_name.setText(bean.getCustomerName() +"("+ bean.getCustomerPhone() +")");
        holder.item_desc.setText(bean.getDesc());
        holder.item_name.setText(bean.getPorductName());
        holder.item_time.setText(bean.getCreteTime());
        holder.item_price.setText("￥"+bean.getBasePrice() + " X" + bean.getNumber());
        return convertView;
    }
}
