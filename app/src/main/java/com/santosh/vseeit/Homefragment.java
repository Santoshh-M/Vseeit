package com.santosh.vseeit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.santosh.vseeit.DBqueries.category_modelList;
import static com.santosh.vseeit.DBqueries.homePagemodelList;
import static com.santosh.vseeit.DBqueries.loadFragmentData;
import static com.santosh.vseeit.DBqueries.loadcategories;

public class Homefragment extends Fragment {

    public Homefragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryrecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homecycle;
    private HomePageAdapter adapter;

//    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryrecyclerView = view.findViewById(R.id.Category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryrecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(category_modelList);
        categoryrecyclerView.setAdapter(categoryAdapter);

        if (category_modelList.size() == 0){
            loadcategories(categoryAdapter,getContext());
        }else {
            categoryAdapter.notifyDataSetChanged();
        }
        homecycle = view.findViewById(R.id.home_page_recycleview);
        LinearLayoutManager testlaymanager = new LinearLayoutManager(getContext());
        testlaymanager.setOrientation(LinearLayoutManager.VERTICAL);
        homecycle.setLayoutManager(testlaymanager);
        adapter = new HomePageAdapter(homePagemodelList);
        homecycle.setAdapter(adapter);

        if (homePagemodelList.size() == 0){
           loadFragmentData(adapter,getContext());
        }else {
            categoryAdapter.notifyDataSetChanged();
        }
        return view;
    }
}