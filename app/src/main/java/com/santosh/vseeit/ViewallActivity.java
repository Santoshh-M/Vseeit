package com.santosh.vseeit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewallActivity extends AppCompatActivity {
        private RecyclerView viewallcycle;
        private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewallcycle = findViewById(R.id.viw_all_cycle);
        gridView = findViewById(R.id.grid_viewall);

        int layout_code = getIntent().getIntExtra("layout_code", -1);
        if (layout_code == 0) {
            viewallcycle.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(layoutManager.VERTICAL);
            viewallcycle.setLayoutManager(layoutManager);
            List<Wishlistmodel> wishlistmodelList = new ArrayList<>();
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 1, "4", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 1, "5", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 2, "2.6", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 3, "2.88", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 1, "4", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 1, "5", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 2, "2.6", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));
            wishlistmodelList.add(new Wishlistmodel(R.drawable.sam, "Samsung M40", 3, "2.88", 150, "Rs. 29,999/-", "Rs. 35,854/-", "Cash on Delivery is avaliable"));

            WishlistAdapter adapter = new WishlistAdapter(wishlistmodelList, false);
            viewallcycle.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else if (layout_code == 1) {
            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone, "Redmi", "SD 730G processor", "Rs. 16,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.sam, "Samsung", "Ram 4GB / 6GB ", "Rs. 13,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.one, "OnePlus", "5G Phone", "Rs. 27,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph, "Iphone", "SD 650 process", "Rs. 50000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone, "Redmi 9 Pro Max", "SD 650 process", "Rs. 99,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph, "Iphone 12", "SD 730G processor", "Rs. 16,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.sam, "Samsung", "Ram 4GB / 6GB ", "Rs. 13,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.one, "OnePlus", "5G Phone", "Rs. 27,999/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.iph, "Iphone", "SD 650 process", "Rs. 50000/-"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.phone, "Redmi 9 Pro Max", "SD 650 process", "Rs. 99,999/-"));

            GridproductAdapter gridproductAdapter = new GridproductAdapter(horizontalProductModelList);
            gridView.setAdapter(gridproductAdapter);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}