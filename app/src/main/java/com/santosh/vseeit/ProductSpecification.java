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

public class ProductSpecification extends Fragment {
    public ProductSpecification() {
        // Required empty public constructor
    }
    private RecyclerView speccycleview;
    public static  List<ProductSpecificationModel> productSpecificationModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_product_specification, container, false);
        speccycleview = view.findViewById(R.id.pro_spec_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        speccycleview.setLayoutManager(linearLayoutManager);

        productSpecificationModelList = new ArrayList<>();


        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter(productSpecificationModelList);
        speccycleview.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();
        return view;
    }
}