package com.santosh.vseeit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.santosh.vseeit.DBqueries.lists;
import static com.santosh.vseeit.DBqueries.loadFragmentData;
import static com.santosh.vseeit.DBqueries.loadedcategory;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categorycycle;
    private HomePageAdapter adapter;
    private List<HomePagemodel> homePagefakemodelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("categoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //homefake
        List<SliderModel> sliderfake = new ArrayList<>();
        sliderfake.add(new SliderModel("null","#dfdfdf"));
        sliderfake.add(new SliderModel("null","#dfdfdf"));
        sliderfake.add(new SliderModel("null","#dfdfdf"));
        sliderfake.add(new SliderModel("null","#dfdfdf"));
        sliderfake.add(new SliderModel("null","#dfdfdf"));

        List<HorizontalProductModel> horizontalfakeModelList = new ArrayList<>();

        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));
        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));
        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));
        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));
        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));
        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));
        horizontalfakeModelList.add(new HorizontalProductModel("","","","",""));

        homePagefakemodelList.add(new HomePagemodel(0,sliderfake));
        homePagefakemodelList.add(new HomePagemodel(1,"","#dfdfdf"));
        homePagefakemodelList.add(new HomePagemodel(2,"","#dfdfdf",horizontalfakeModelList,new ArrayList<Wishlistmodel>()));
        homePagefakemodelList.add(new HomePagemodel(3,"","#dfdfdf",horizontalfakeModelList));
        //homefake


        categorycycle = findViewById(R.id.category_recycleview);
        LinearLayoutManager testlaymanager = new LinearLayoutManager(this);
        testlaymanager.setOrientation(LinearLayoutManager.VERTICAL);
        categorycycle.setLayoutManager(testlaymanager);
        adapter = new HomePageAdapter(homePagefakemodelList);

        int listposition = 0;
        for (int v=0; v < loadedcategory.size();v++){
            if (loadedcategory.get(v).equals(title.toUpperCase())){
                listposition = v;
            }
        }
        if (listposition == 0){
            loadedcategory.add(title.toUpperCase());
            lists.add(new ArrayList<HomePagemodel>());
            loadFragmentData(categorycycle,this,loadedcategory.size() - 1,title);
        }else{
            adapter = new HomePageAdapter(lists.get(listposition));
        }
        categorycycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        /////////
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
         if (id == R.id.main_search_icon) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
}