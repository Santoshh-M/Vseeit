package com.santosh.vseeit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class Homefragment extends Fragment {

    public Homefragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryrecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homecycle;
    private HomePageAdapter adapter;
    private List<Category_model> category_modelList;
    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryrecyclerView = view.findViewById(R.id.Category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        categoryrecyclerView.setLayoutManager(layoutManager);
        category_modelList = new ArrayList<Category_model>();

        categoryAdapter = new CategoryAdapter(category_modelList);
        categoryrecyclerView.setAdapter(categoryAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                category_modelList.add(new Category_model(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        /* Banner slider */
//        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();
//        sliderModelList.add(new SliderModel(R.drawable.email_green,"#ffffff"));
        /* Banner slider */


        //////Horizontal_view
//        List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone,"Redmi","SD 730G processor", "Rs. 16,999/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.sam,"Samsung","Ram 4GB / 6GB ", "Rs. 13,999/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.one,"OnePlus","5G Phone", "Rs. 27,999/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone,"Redmi 9 Pro Max","SD 650 process", "Rs. 99,999/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.sam,"Samsung","Ram 4GB / 6GB ", "Rs. 13,999/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.one,"OnePlus","5G Phone", "Rs. 27,999/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph,"Iphone","SD 650 process", "Rs. 50000/-"));
//        ////////Horizontal_view

        //////////

        homecycle = view.findViewById(R.id.home_page_recycleview);
        LinearLayoutManager testlaymanager = new LinearLayoutManager(getContext());
        testlaymanager.setOrientation(LinearLayoutManager.VERTICAL);
        homecycle.setLayoutManager(testlaymanager);
        final List<HomePagemodel> homePagemodelList = new ArrayList<>();
        adapter = new HomePageAdapter(homePagemodelList);
        homecycle.setAdapter(adapter);

        firebaseFirestore.collection("CATEGORIES")
                .document("HOME")
                .collection("TOP_DEALS")
                .orderBy("index")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                if ((long)documentSnapshot.get("view_type") == 0) {
                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners = (long)documentSnapshot.get("no_of_banners");
                                    for (long s = 1; s < no_of_banners + 1; s++) {
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_" + s).toString(),
                                                documentSnapshot.get("banner_" + s + "_bg").toString()));
                                    }
                                    homePagemodelList.add(new HomePagemodel(0, sliderModelList));
                                } else if ((long) documentSnapshot.get("view_type") == 1) {
                                    homePagemodelList.add(new HomePagemodel(1, documentSnapshot.get("strip_ad_banner").toString(),
                                            documentSnapshot.get("background").toString()));
                                } else if ((long) documentSnapshot.get("view_type") == 2) {

                                } else if ((long) documentSnapshot.get("view_type") == 3) {

                                }
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        /////////
        return view;
    }
}