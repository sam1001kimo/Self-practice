package com.example.sam10.mycompoment.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 通用ViewHolder
 */
public class CommonViewHolder {

    //所有控制元件的集合
    private SparseArray<View> mViews;
    //記錄位置 可能會用到
    private int mPosition;
    //複用的View
    private View mConvertView;


    /**
     * 建構函式
     *
     * @param context  上下文對像
     * @param parent   父類容器
     * @param layoutId 佈局的ID
     * @param position item的位置
     */
    public CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 得到一個ViewHolder
     *
     * @param context     上下文對像
     * @param convertView 複用的View
     * @param parent      父類容器
     * @param layoutId    佈局的ID
     * @param position    item的位置
     * @return 返回ViewHolder
     */
    public static CommonViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        //如果為空  直接新建一個ViewHolder
        if (convertView == null) {
            return new CommonViewHolder(context, parent, layoutId, position);
        } else {
            //否則返回一個已經存在的ViewHolder
            CommonViewHolder viewHolder = (CommonViewHolder) convertView.getTag();
            //記得更新條目位置
            viewHolder.mPosition = position;
            return viewHolder;
        }
    }

    /**
     * @return 返回複用的View
     */
    public View getConvertView() {
        return mConvertView;
    }


    /**
     * 通過ViewId獲取控制元件
     *
     * @param viewId View的Id
     * @param <T>    View的子類
     * @return 返回View
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 為文字設定text
     *
     * @param viewId view的Id
     * @param text   文字
     * @return 返回ViewHolder
     */
    public CommonViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 設定ImageView
     *
     * @param viewId view的Id
     * @param resId  資源Id
     * @return 返回ViewHolder
     */
    public CommonViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    /**
     * 還可以新增更多的方法
     */
}
