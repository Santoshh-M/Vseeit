package com.santosh.vseeit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.santosh.vseeit.ProductActivity.productDescription;
import static com.santosh.vseeit.ProductActivity.tabposition;

public class ProductDescriptionFragment extends Fragment {

    public ProductDescriptionFragment() {
    }

    private TextView descriptionbody;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_description, container, false);
        descriptionbody = v.findViewById(R.id.tv_pro_des);
        if (tabposition == 0){
            descriptionbody.setText(productDescription);
        }else {
            descriptionbody.setText(productDescription);
        }
        return v;
    }
}
