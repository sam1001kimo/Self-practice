package com.example.sam10.mycompoment.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用Adapter抽像類
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> list;
    private int layoutId;

    public CommonAdapter(Context context, List<T> list, int layoutId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 封裝getView方法
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //得到一個ViewHolder
        CommonViewHolder viewHolder = CommonViewHolder.get(context, convertView, parent, layoutId, position);

        //設定控制元件內容
        setViewContent(viewHolder, (T) getItem(position));

        //返回複用的View
        return viewHolder.getConvertView();
    }

    /**
     * 提供抽像方法，來設定控制元件內容
     *
     * @param viewHolder 一個ViewHolder
     * @param t          一個數據集
     */
    public abstract void setViewContent(CommonViewHolder viewHolder, T t);
}
