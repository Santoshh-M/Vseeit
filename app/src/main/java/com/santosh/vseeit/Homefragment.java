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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.santosh.vseeit.DBqueries.category_modelList;
import static com.santosh.vseeit.DBqueries.lists;
import static com.santosh.vseeit.DBqueries.loadFragmentData;
import static com.santosh.vseeit.DBqueries.loadcategories;
import static com.santosh.vseeit.DBqueries.loadedcategory;

public class Homefragment extends Fragment {

    public Homefragment() {
        // Required empty public constructor
    }
    public static SwipeRefreshLayout refreshLayout;
    private RecyclerView categoryrecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category_model> categoryfakemodelList = new ArrayList<>();
    private RecyclerView homecycle;
    private HomePageAdapter adapter;
    private List<HomePagemodel> homePagefakemodelList = new ArrayList<>();
    private ImageView nointconnection;
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;

//    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        refreshLayout = view.findViewById(R.id.refresh_layout);
        nointconnection = view.findViewById(R.id.no_internet);

        categoryrecyclerView = view.findViewById(R.id.Category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryrecyclerView.setLayoutManager(layoutManager);
       //categoryfake

        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryfakemodelList.add(new Category_model("null",""));
        categoryAdapter = new CategoryAdapter(categoryfakemodelList);
        categoryrecyclerView.setAdapter(categoryAdapter);
        //categoryfake

        //homefake
        List<SliderModel> sliderfake = new ArrayList<>();
        sliderfake.add(new SliderModel("null","#ffffff"));
        sliderfake.add(new SliderModel("null","#ffffff"));
        sliderfake.add(new SliderModel("null","#ffffff"));
        sliderfake.add(new SliderModel("null","#ffffff"));
        sliderfake.add(new SliderModel("null","#ffffff"));
        //homefake

        connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {
            nointconnection.setVisibility(View.GONE);



            if (category_modelList.size() == 0){
                loadcategories(categoryrecyclerView,getContext());
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
        /// refresh
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);

                category_modelList.clear();
                lists.clear();
                loadedcategory.clear();
                if (networkInfo != null && networkInfo.isConnected() == true) {
                    nointconnection.setVisibility(View.GONE);
                    categoryrecyclerView.setAdapter(categoryAdapter);

                    loadcategories(categoryrecyclerView,getContext());

                    loadedcategory.add("HOME");
                    lists.add(new ArrayList<HomePagemodel>());
                    loadFragmentData(adapter,getContext(),0,"Home");
                } else {
                    Glide.with(getContext()).load(R.drawable.img).into(nointconnection);
                    nointconnection.setVisibility(View.VISIBLE);
                }
            }
        });
        /// refresh

        return view;
    }
}