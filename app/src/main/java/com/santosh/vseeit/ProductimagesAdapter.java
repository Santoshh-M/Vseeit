package com.santosh.vseeit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ProductimagesAdapter extends PagerAdapter {

    private List<Integer> productImages;

    public ProductimagesAdapter(List<Integer> productImages) {
        this.productImages = productImages;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView proimage = new ImageView(container.getContext());
        proimage.setImageResource(productImages.get(position));
        container.addView(proimage,0);
        return proimage;
       }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
            }

    @Override
    public int getCount() {
        return productImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
