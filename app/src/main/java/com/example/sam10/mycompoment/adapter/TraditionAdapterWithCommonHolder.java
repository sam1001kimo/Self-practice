package com.example.sam10.mycompoment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.example.sam10.mycompoment.R;
import com.example.sam10.mycompoment.bean.NewsBean;
import com.example.sam10.mycompoment.utils.CommonViewHolder;

import java.util.List;

/**
 * 通用Holder的適配器
 */
public class TraditionAdapterWithCommonHolder extends BaseAdapter {
    private Context context;
    private List<NewsBean> list;

    public TraditionAdapterWithCommonHolder(Context context, List<NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //得到一個ViewHolder
        CommonViewHolder viewHolder = CommonViewHolder.get(context, convertView, parent, R.layout.item_list, position);

        NewsBean bean = list.get(position);

        //直接設定控制元件內容，鏈式呼叫
        viewHolder.setText(R.id.tv_title, bean.getTitle())
                .setText(R.id.tv_desc, bean.getDesc())
                .setText(R.id.tv_time, bean.getTime())
                .setText(R.id.tv_phone, bean.getPhone());

        //返回複用的View
        return viewHolder.getConvertView();
    }
}
