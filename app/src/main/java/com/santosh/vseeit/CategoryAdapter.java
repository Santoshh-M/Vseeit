package com.santosh.vseeit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
        private List<Category_model> category_modelList;

    public CategoryAdapter(List<Category_model> category_modelList) {
        this.category_modelList = category_modelList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        String icon = category_modelList.get(position).getCategoryIconLink();
        String name = category_modelList.get(position).getCategoryName();
        holder.setCategory(name);
    }

    @Override
    public int getItemCount() {
        return category_modelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageicon;
        private TextView category_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageicon = itemView.findViewById(R.id.category_icon);
            category_text = itemView.findViewById(R.id.category_text);
        }
        private void setImageicon(){
            //todo work
        }
        private void setCategory(final String name){
            category_text.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 Intent categoryIntent = new Intent(itemView.getContext(),CategoryActivity.class);
                 categoryIntent.putExtra("Category",name);
                 itemView.getContext().startActivity(categoryIntent);
                }
            });
        }
    }
}
