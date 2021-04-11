package com.santosh.vseeit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ProductDetailsAdapter extends FragmentPagerAdapter {
    private int ttlTabs;
    private String proDescription;
    private String proOtherdetails;
    private List<ProductSpecificationModel> productSpecificationModelList;

    public ProductDetailsAdapter(@NonNull FragmentManager fm, int ttlTabs, String proDescription, String proOtherdetails, List<ProductSpecificationModel> productSpecificationModelList) {
        super(fm);
        this.ttlTabs = ttlTabs;
        this.proDescription = proDescription;
        this.proOtherdetails = proOtherdetails;
        this.productSpecificationModelList = productSpecificationModelList;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
                ProductDescriptionFragment productDescriptionFragment = new ProductDescriptionFragment();
                productDescriptionFragment.body = proDescription;
                return productDescriptionFragment;
           case 1:
               ProductSpecification productSpecification = new ProductSpecification();
               productSpecification.productSpecificationModelList = productSpecificationModelList;
               return productSpecification;
           case 2:
               ProductDescriptionFragment productDescriptionFragment1 = new ProductDescriptionFragment();
               productDescriptionFragment1.body = proOtherdetails;
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
