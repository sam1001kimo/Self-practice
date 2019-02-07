package com.example.sam10.mycompoment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sam10.mycompoment.ActMain;

public class FragmentOne extends Fragment {

    private RadioGroup.OnCheckedChangeListener radioGroup_click = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                //這裡不做radioButton1的全域宣告，此時的R.id.radioButton1只是一個int
                case R.id.radioButton1:
                    //如果不用在fragment的時候是使用
                    //getWindow().getDecorView().setBackgroundColor
                    getView().setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case R.id.radioButton2:
                    getView().setBackgroundColor(Color.parseColor("#FFFF00"));
                    break;
                case R.id.radioButton3:
                    getView().setBackgroundColor(Color.parseColor("#FF00FF"));
                    break;
                case R.id.radioButton4:
                    getView().setBackgroundColor(Color.parseColor("#00FFFF"));
                    break;

            }

        }
    };
    //ratingbar的值改變
    private RatingBar.OnRatingBarChangeListener ratingBar_change = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingText.setText(String.valueOf(rating));
        }
    };
    private View.OnClickListener gotoFragmentTwo_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActMain.setter(1);
        }
    };
    private View.OnClickListener getGotoFragmentThree_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActMain.setter(2);
        }
    };


    public FragmentOne() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //這裡的toast要用getActivity()不能使用this
        //Toast.makeText(getActivity(), "這是第一頁", Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragmentone, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void InitialCompoment() {
        //在fragment使用findviewbyid前要使用getView或getActivity或getWindows
        radioGroup = getView().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroup_click);
        ratingBar = getView().findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(ratingBar_change);
        ratingText = getView().findViewById(R.id.ratingText);
        gotoFragmentTwo = getView().findViewById(R.id.gotoFragmentTwo);
        gotoFragmentTwo.setOnClickListener(gotoFragmentTwo_click);
        getGotoFragmentThree = getView().findViewById(R.id.gotoFragmentThree);
        getGotoFragmentThree.setOnClickListener(getGotoFragmentThree_click);


    }


    @Override
    public void onResume() {
        super.onResume();
//        Toast toast1 = Toast.makeText(getActivity(), "這是第一頁Resume", Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.RIGHT, 0, 0);
//        toast1.show();
        //fragment在使用findviewbyid不能在onCreateview或onCreate中，要等到view建立好才行
        //所以只能在onAttach或onResume等等的週期才行(onAttach時好時壞)
        InitialCompoment();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        Toast toast1 = Toast.makeText(getActivity(), "這是第一頁attach", Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.LEFT, 0, 0);
//        toast1.show();


    }


    RadioGroup radioGroup;
    RatingBar ratingBar;
    TextView ratingText;
    Button gotoFragmentTwo;
    Button getGotoFragmentThree;

}
