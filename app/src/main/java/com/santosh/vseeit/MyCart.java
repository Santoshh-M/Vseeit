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

public class MyCart extends Fragment {

    public MyCart() {
        // Required empty public constructor
    }
    private RecyclerView cartcycle;

    // TODO: Rename and change types and number of parameters
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);
    cartcycle = view.findViewById(R.id.cart_cycle);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    cartcycle.setLayoutManager(layoutManager);

        List<CartitemModel> cartitemModelList = new ArrayList<>();
        cartitemModelList.add(new CartitemModel(0,R.drawable.phone,"Iphone 12","Rs.49,999/-","Rs.4,999/-",2,1,0,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.phone,"Iphone 12","Rs.49,999/-","Rs.4,999/-",2,2,0,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.phone,"Iphone 12","Rs.49,999/-","Rs.4,999/-",2,3,0,0));
        cartitemModelList.add(new CartitemModel( 1, "Price (3 items)","Rs.149,997/-","Free","Rs.16,997/-","599"));

        CartAdapter cartAdapter = new CartAdapter(cartitemModelList);
        cartcycle.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        return (view);
    }
}