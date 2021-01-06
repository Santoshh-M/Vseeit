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

public class HorizontalProductAdapter extends RecyclerView.Adapter<HorizontalProductAdapter.ViewHolder> {

    private List<HorizontalProductModel> horizontalProductModelList;

    public HorizontalProductAdapter(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }

    @NonNull
    @Override
    public HorizontalProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductAdapter.ViewHolder holder, int position) {
        int resource = horizontalProductModelList.get(position).getProductimg();
        String title = horizontalProductModelList.get(position).getProductitle();
        String description = horizontalProductModelList.get(position).getProductdis();
        String price = horizontalProductModelList.get(position).getProductprice();

        holder.setPrimg(resource);
        holder.setPrtitle(title);
        holder.setPrdis(description);
        holder.setPrprice(price);
    }

    @Override
    public int getItemCount() {
        if (horizontalProductModelList.size() > 8) {
            return 8;
        } else {
            return horizontalProductModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView primg;
            private TextView prtitle;
            private TextView prdis;
            private TextView prprice;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            primg = itemView.findViewById(R.id.h_s_product_img);
            prtitle = itemView.findViewById(R.id.h_s_product_title);
            prdis = itemView.findViewById(R.id.h_s_product_dis);
            prprice = itemView.findViewById(R.id.h_s_product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pdIntent = new Intent(itemView.getContext(),ProductActivity.class);
                    itemView.getContext().startActivity(pdIntent);
                }
            });
        }
        private void setPrimg(int resource){
            primg.setImageResource(resource);
        }
        private void setPrtitle(String title){
            prtitle.setText(title);
        }
        private void setPrdis(String description){
            prdis.setText(description);
        }
        private void setPrprice(String price){
            prprice.setText(price);
        }
    }
}
