package com.santosh.vseeit;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private ViewPager proimgviewpager;
    private TabLayout viewpagerIndi;
    private ViewPager productDetailsviewpager;
    private TabLayout productDetailsTablayout;

    /////rating layout
    private LinearLayout ratenow;

    /////rating layout
    private static boolean ALREADY_ADDED_TO_WISH = false;
    private FloatingActionButton addtowish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            proimgviewpager = findViewById(R.id.pro_images_vwpager);
            viewpagerIndi = findViewById(R.id.viewpager_indicator);
            addtowish = findViewById(R.id.adtowish);
            productDetailsviewpager = findViewById(R.id.product_details_viewpager);
            productDetailsTablayout = findViewById(R.id.product_details_tablayout);

        List<Integer> productImgs = new ArrayList<>();
        productImgs.add(R.drawable.phone);
        productImgs.add(R.drawable.phone);
        productImgs.add(R.drawable.splashscreen);
        productImgs.add(R.drawable.forgotpass);


        ProductimagesAdapter productimagesAdapter = new ProductimagesAdapter(productImgs);
        proimgviewpager.setAdapter(productimagesAdapter);

            viewpagerIndi.setupWithViewPager(proimgviewpager,true);
            addtowish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISH){
                    ALREADY_ADDED_TO_WISH =  false;
                        addtowish.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                    }else{
                    ALREADY_ADDED_TO_WISH = true;
                        addtowish.setSupportImageTintList(getResources().getColorStateList(R.color.red));
                    }
                }
            });

        productDetailsviewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTablayout.getTabCount()));
        productDetailsviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ///////rating layout
        ratenow = findViewById(R.id.rate_str_5);
        for (int x = 0;x < ratenow.getChildCount(); x++){
          final int starposition = x;
          ratenow.getChildAt(x).setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                setRating(starposition);
              }
          });
        }
        ///////rating layout
    }

    private void setRating(int starposition) {
    for (int s = 0;s < ratenow.getChildCount();s++){
        ImageView strbtn = (ImageView)ratenow.getChildAt(s);
        strbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
        if (s <= starposition) {
            strbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFBF00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.main_search_icon) {
            return true;
        }
        else if (id == R.id.main_cart_icon) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}