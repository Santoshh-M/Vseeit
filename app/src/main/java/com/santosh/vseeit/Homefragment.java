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


public class Homefragment extends Fragment {

    public Homefragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryrecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryrecyclerView = view.findViewById(R.id.Category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryrecyclerView.setLayoutManager(layoutManager);

        final List<Category_model> category_modelList = new ArrayList<Category_model>();
        category_modelList.add(new Category_model("link", "Home"));
        category_modelList.add(new Category_model("link", "Electronics"));
        category_modelList.add(new Category_model("link", "Appliances"));
        category_modelList.add(new Category_model("link", "Furnitures"));
        category_modelList.add(new Category_model("link", "Fashion"));
        category_modelList.add(new Category_model("link", "Food"));
        category_modelList.add(new Category_model("link", "Toys"));
        category_modelList.add(new Category_model("link", "Sports"));
        category_modelList.add(new Category_model("link", "Grocery items"));

        categoryAdapter = new CategoryAdapter(category_modelList);
        categoryrecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        /* Banner slider */
        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.email_green,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.ban,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.gro,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.nad,"#f59204"));
        sliderModelList.add(new SliderModel(R.mipmap.app_icon,"#1794c8"));
        sliderModelList.add(new SliderModel(R.drawable.vseeit,"#ffe50a"));
        sliderModelList.add(new SliderModel(R.drawable.splashscreen,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.forgotpass,"#ffffff"));

        /* Banner slider */


        //////Horizontal_view
        List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone,"Redmi","SD 730G processor", "Rs. 16,999/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.sam,"Samsung","Ram 4GB / 6GB ", "Rs. 13,999/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.one,"OnePlus","5G Phone", "Rs. 27,999/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone,"Redmi 9 Pro Max","SD 650 process", "Rs. 99,999/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.sam,"Samsung","Ram 4GB / 6GB ", "Rs. 13,999/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.one,"OnePlus","5G Phone", "Rs. 27,999/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
        ////////Horizontal_view

        //////////
        test = view.findViewById(R.id.home_page_recycleview);
        LinearLayoutManager testlaymanager = new LinearLayoutManager(getContext());
        testlaymanager.setOrientation(LinearLayoutManager.VERTICAL);
        test.setLayoutManager(testlaymanager);

        List<HomePagemodel> homePagemodelList = new ArrayList<>();
        homePagemodelList.add(new HomePagemodel(0,sliderModelList));
        homePagemodelList.add(new HomePagemodel(1,R.drawable.strip,"#ffe50a"));
        homePagemodelList.add(new HomePagemodel(2,"New Arrivals",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(3,"Special Offers",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(1,R.drawable.strip,"#FFEF6C00"));
        homePagemodelList.add(new HomePagemodel(3,"Exclusive deals",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(2,"Deals of the Day",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(1,R.drawable.strip,"FFEF6C00"));

        HomePageAdapter adapter = new HomePageAdapter(homePagemodelList);
        test.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        /////////
        return view;
    }
}