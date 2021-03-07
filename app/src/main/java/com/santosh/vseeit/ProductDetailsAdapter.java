package com.santosh.vseeit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductDetailsAdapter extends FragmentPagerAdapter {
    private int ttlTabs;
    public ProductDetailsAdapter(@NonNull FragmentManager fm, int ttlTabs) {
        super(fm);
        this.ttlTabs = ttlTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
                ProductDescriptionFragment productDescriptionFragment = new ProductDescriptionFragment();
                return productDescriptionFragment;
           case 1:
               ProductSpecification productSpecification = new ProductSpecification();
               return productSpecification;
           case 2:
               ProductDescriptionFragment productDescriptionFragment1 = new ProductDescriptionFragment();
               return productDescriptionFragment1;
           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return ttlTabs;
    }
}
