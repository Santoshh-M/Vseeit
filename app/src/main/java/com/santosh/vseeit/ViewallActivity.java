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

import java.util.List;

public class ViewallActivity extends AppCompatActivity {
        private RecyclerView viewallcycle;
        private GridView gridView;
        public static List<Wishlistmodel> wishlistmodelList;
        public static List<HorizontalProductModel> horizontalProductModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewallcycle = findViewById(R.id.viw_all_cycle);
        gridView = findViewById(R.id.grid_viewall);

        int layout_code = getIntent().getIntExtra("layout_code", -1);
        if (layout_code == 0) {
            viewallcycle.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(layoutManager.VERTICAL);
            viewallcycle.setLayoutManager(layoutManager);

            WishlistAdapter adapter = new WishlistAdapter(wishlistmodelList, false);
            viewallcycle.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else if (layout_code == 1) {
            gridView.setVisibility(View.VISIBLE);

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