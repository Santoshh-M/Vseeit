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

public class MywishlistFragment extends Fragment {
    public MywishlistFragment() {
        // Required empty public constructor
    }
    private RecyclerView wishcycle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_mywishlist, container, false);
       wishcycle = view.findViewById(R.id.wishcycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishcycle.setLayoutManager(linearLayoutManager);

        List<Wishlistmodel> wishlistmodelList = new ArrayList<>();

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistmodelList,true);
        wishcycle.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;
    }
}