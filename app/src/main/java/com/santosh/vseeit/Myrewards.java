package com.santosh.vseeit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Myrewards extends Fragment {

    public Myrewards() {
        // Required empty public constructor
    }
    private RecyclerView rewardcycle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_myrewards, container, false);
        rewardcycle = view.findViewById(R.id.reward_cycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardcycle.setLayoutManager(linearLayoutManager);
        List<RewardModel>rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback","Till 21st, March 2020","GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Buy one get one","Till 04st, November 2020","GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Mega Discount","Till 08th, October 2020","GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Special Coupon","Till 05th, June 2021","GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Scratch Card","Till 12th, August 2020","GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Vseeit Coupon","Till 25th, April 2050","GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));

        RewardAdapter rw = new RewardAdapter(rewardModelList);
        rewardcycle.setAdapter(rw);
        rw.notifyDataSetChanged();
        return view;
    }
}