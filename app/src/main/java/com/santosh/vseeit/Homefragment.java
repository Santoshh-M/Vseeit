package com.santosh.vseeit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.santosh.vseeit.DBqueries.category_modelList;
import static com.santosh.vseeit.DBqueries.lists;
import static com.santosh.vseeit.DBqueries.loadFragmentData;
import static com.santosh.vseeit.DBqueries.loadcategories;
import static com.santosh.vseeit.DBqueries.loadedcategory;

public class Homefragment extends Fragment {

    public Homefragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryrecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homecycle;
    private HomePageAdapter adapter;
    private ImageView nointconnection;

//    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        nointconnection = view.findViewById(R.id.no_internet);

        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {
            nointconnection.setVisibility(View.GONE);

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

            if (lists.size() == 0){
                loadedcategory.add("HOME");
                lists.add(new ArrayList<HomePagemodel>());
                adapter = new HomePageAdapter(lists.get(0));
                loadFragmentData(adapter,getContext(),0,"Home");
            }else {
                adapter = new HomePageAdapter(lists.get(0));
                adapter.notifyDataSetChanged();
            }
            homecycle.setAdapter(adapter);
        }else {
            Glide.with(this).load(R.drawable.img).into(nointconnection);
            nointconnection.setVisibility(View.VISIBLE);
        }

        return view;
    }
}