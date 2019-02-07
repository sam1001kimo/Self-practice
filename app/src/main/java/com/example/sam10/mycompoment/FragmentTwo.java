package com.example.sam10.mycompoment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sam10.mycompoment.adapter.CommonAdapterWithCommonHolder;
import com.example.sam10.mycompoment.adapter.TraditionAdapterWithCommonHolder;
import com.example.sam10.mycompoment.adapter.TraditionAdapterWithTraditionHolder;
import com.example.sam10.mycompoment.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {

    public FragmentTwo(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Toast toast1 = Toast.makeText(getActivity(),"這是第二頁",Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.CENTER,0,0);
//        toast1.show();

        return inflater.inflate(R.layout.fragmenttwo,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
//        Toast toast1 = Toast.makeText(getActivity(),"這是第二頁Resume",Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.TOP,0,0);
//        toast1.show();
        initDatas();

        initView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        Toast toast1 = Toast.makeText(getActivity(),"這是第二頁attach",Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.LEFT,0,0);
//        toast1.show();
    }



    /**
     * 初始化數據
     */
    private ListView mainListView;
    private List<NewsBean> listDatas;
    private TraditionAdapterWithTraditionHolder tAdapter;
    private TraditionAdapterWithCommonHolder chAdapter;
    private CommonAdapterWithCommonHolder cawchAdapter;


    private void initDatas() {
        listDatas = new ArrayList<>();

        NewsBean bean1 = new NewsBean("第一條數據", "第一條數據的描述", "2019-2-8", "0900111111");
        listDatas.add(bean1);

        NewsBean bean2 = new NewsBean("第二條數據", "第二條數據的描述", "2019-2-7", "0900222222");
        listDatas.add(bean2);

        NewsBean bean3 = new NewsBean("第三條數據", "第三條數據的描述", "2019-2-6", "0900333333");
        listDatas.add(bean3);

        NewsBean bean4 = new NewsBean("第四條數據", "第四條數據的描述", "2019-2-5", "0900444444");
        listDatas.add(bean4);

        NewsBean bean5 = new NewsBean("第五條數據", "第五條數據的描述", "2019-2-4", "0900555555");
        listDatas.add(bean5);
    }

    /**
     * 初始化View
     */
    private void initView() {
        mainListView = (ListView) getView().findViewById(R.id.lv_main);

        //傳統方式的Adapter
        //tAdapter = new TraditionAdapterWithTraditionHolder(this, listDatas);
        //mainListView.setAdapter(tAdapter);

        //通用ViewHolder方式的Adapter
        //chAdapter = new TraditionAdapterWithCommonHolder(this, listDatas);
        //mainListView.setAdapter(chAdapter);

        //通用Adapter
        cawchAdapter = new CommonAdapterWithCommonHolder(getActivity(), listDatas);
        mainListView.setAdapter(cawchAdapter);
    }
}
