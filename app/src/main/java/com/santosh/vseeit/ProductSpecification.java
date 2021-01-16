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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_product_specification, container, false);
        speccycleview = view.findViewById(R.id.pro_spec_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        speccycleview.setLayoutManager(linearLayoutManager);
        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel("RAM", "4GB"));
        productSpecificationModelList.add(new ProductSpecificationModel("Battery", "5000 Mah"));
        productSpecificationModelList.add(new ProductSpecificationModel("Camera", "Dual"));
        productSpecificationModelList.add(new ProductSpecificationModel("Radio", "Yes"));
        productSpecificationModelList.add(new ProductSpecificationModel("ROM", "64Gb"));
        productSpecificationModelList.add(new ProductSpecificationModel("Volte", "Yes"));
        productSpecificationModelList.add(new ProductSpecificationModel("Front Camera", "16Mp"));
        productSpecificationModelList.add(new ProductSpecificationModel("Back Camera", "32Mp"));
        productSpecificationModelList.add(new ProductSpecificationModel("Screen Size", "6.1"));
        productSpecificationModelList.add(new ProductSpecificationModel("OS", "Android 10"));
        productSpecificationModelList.add(new ProductSpecificationModel("SD Card support", "Yes"));

        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter();
        speccycleview.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();
        return view;
    }
}