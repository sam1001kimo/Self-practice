package com.example.sam10.mycompoment.adapter;
import android.content.Context;


import com.example.sam10.mycompoment.R;
import com.example.sam10.mycompoment.bean.NewsBean;
import com.example.sam10.mycompoment.utils.CommonAdapter;
import com.example.sam10.mycompoment.utils.CommonViewHolder;

import java.util.List;

/**
 * 繼承通用Adapter且使用通用Holder的適配器
 */
public class CommonAdapterWithCommonHolder extends CommonAdapter<NewsBean> {


    public CommonAdapterWithCommonHolder(Context context, List<NewsBean> list) {
        super(context, list,R.layout.item_list);
    }

    /**
     * 複寫抽像方法
     * @param viewHolder 一個ViewHolder
     * @param bean Bean對像
     */
    @Override
    public void setViewContent(CommonViewHolder viewHolder, NewsBean bean) {

        //直接設定內容 鏈式呼叫
        viewHolder.setText(R.id.tv_title, bean.getTitle())
                .setText(R.id.tv_desc, bean.getDesc())
                .setText(R.id.tv_time, bean.getTime())
                .setText(R.id.tv_phone, bean.getPhone());
    }
}
