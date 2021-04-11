package com.santosh.vseeit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProductDescriptionFragment extends Fragment {

    public ProductDescriptionFragment() {
    }

    private TextView descriptionbody;
    public String body;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_description, container, false);
        descriptionbody = v.findViewById(R.id.tv_pro_des);
        descriptionbody.setText(body);
        return v;
    }
}
