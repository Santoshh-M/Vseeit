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

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categorycycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categorycycle = findViewById(R.id.category_recycleview);


        //Banner slider
        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.splashscreen,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.forgotpass,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.email_green,"#ffffff"));

        sliderModelList.add(new SliderModel(R.drawable.mail,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.settings,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.vseeit,"#000000"));
        sliderModelList.add(new SliderModel(R.mipmap.app_icon,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.gift,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.splashscreen,"#ffffff"));

        sliderModelList.add(new SliderModel(R.drawable.forgotpass,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.email_green,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.mail,"#000000"));
        //Banner slider


        ////////Horizontal_view


        List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.account,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.home,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.gift,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.close,"Iphone","SD 650 process", "Rs. 50000/-"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.wishlist,"Iphone","SD 650 process", "Rs. 50000/-"));
        ////////Horizontal_view

        //////////
        LinearLayoutManager testlaymanager = new LinearLayoutManager(this);
        testlaymanager.setOrientation(LinearLayoutManager.VERTICAL);
        categorycycle.setLayoutManager(testlaymanager);

        List<HomePagemodel> homePagemodelList = new ArrayList<>();
        homePagemodelList.add(new HomePagemodel(0,sliderModelList));
        homePagemodelList.add(new HomePagemodel(1,R.drawable.bag,"#ffffff"));
        homePagemodelList.add(new HomePagemodel(2,"Deals of the Day",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(3,"Deals of the Day",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(1,R.drawable.splashscreen,"#ffff00"));
        homePagemodelList.add(new HomePagemodel(3,"Deals of the Day",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(2,"Deals of the Day",horizontalProductModelList));
        homePagemodelList.add(new HomePagemodel(1,R.drawable.wishlist,"#ffffff"));
        HomePageAdapter adapter = new HomePageAdapter(homePagemodelList);
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