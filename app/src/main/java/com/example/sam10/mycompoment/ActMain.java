package com.example.sam10.mycompoment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialCompoment();
        setupViewPager();

    }

    private void InitialCompoment() {
        vp = findViewById(R.id.viewpager);
        tb = findViewById(R.id.tabs);

    }
    ViewPager vp;
    static  TabLayout tb;


    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne());
        adapter.addFragment(new FragmentTwo());
        adapter.addFragment(new FragmentThree());

        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
        tb.setBackgroundColor(getResources().getColor(R.color.codeBlue));
        tb.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.black));

        tb.getTabAt(0).setText("1");
        tb.getTabAt(1).setText("2");
        tb.getTabAt(2).setText("3");



    }
    //給fragment內按鈕跳轉使用
    public static void setter(int i){
        tb.getTabAt(i).select();
    }



}
