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

public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
        // Required empty public constructor
    }
    private RecyclerView myordercycle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        myordercycle = view.findViewById(R.id.my_orders_cycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myordercycle.setLayoutManager(linearLayoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.sam,"Samsung 2","Delivered on Thu, 26th Mar 2021",2));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.phone,"Redmi 9 pro","Delivered on Fri, 27th Mar 2021",2));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.iph,"I phone","Cancelled",2));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.sam,"Samsung 2","Refund completed",2));
    MyorderAdapter myorderAdapter =  new MyorderAdapter(myOrderItemModelList);
    myordercycle.setAdapter(myorderAdapter);
    myorderAdapter.notifyDataSetChanged();
        return view;

    }
}