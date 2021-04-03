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
        //////////
        LinearLayoutManager testlaymanager = new LinearLayoutManager(this);
        testlaymanager.setOrientation(LinearLayoutManager.VERTICAL);
        categorycycle.setLayoutManager(testlaymanager);
        List<HomePagemodel> homePagemodelList = new ArrayList<>();
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