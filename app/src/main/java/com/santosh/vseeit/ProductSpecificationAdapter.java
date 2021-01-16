package com.santosh.vseeit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductSpecificationAdapter extends RecyclerView.Adapter<ProductSpecificationAdapter.ViewHolder> {

    private List<ProductSpecificationModel> productSpecificationModelList;


    @NonNull
    @Override
    public ProductSpecificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pro_spec_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationAdapter.ViewHolder holder, int position) {
        String featureTitle = productSpecificationModelList.get(position).getFeatureName();
        String featureDetails = productSpecificationModelList.get(position).getFeatureValue();
        holder.setFeatures(featureTitle,featureDetails);
    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private TextView fName;
       private TextView fvalue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.feature_name);
            fvalue = itemView.findViewById(R.id.feature_value);
        }
        private void setFeatures(String featureTitle,String featuredetails) {
            fName.setText(featureTitle);
            fvalue.setText(featuredetails);
        }
    }
}
