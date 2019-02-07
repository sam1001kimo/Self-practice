package com.example.sam10.mycompoment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentThree extends Fragment {


    public FragmentThree() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentthree,container,false);
    }


    @Override
    public void onResume() {
        super.onResume();

        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member(1, R.drawable.animal_pig, "豬年行大運"));
        memberList.add(new Member(2, R.drawable.animal_koala, "可愛的無尾熊"));
        memberList.add(new Member(3, R.drawable.animal_hamster, "吃瓜的哈姆太郎"));
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MemberAdapter(getActivity(), memberList));
    }






}
