package com.santosh.vseeit;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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
        String productID = horizontalProductModelList.get(position).getProductID();
        String resource = horizontalProductModelList.get(position).getProductimg();
        String title = horizontalProductModelList.get(position).getProductitle();
        String description = horizontalProductModelList.get(position).getProductdis();
        String price = horizontalProductModelList.get(position).getProductprice();

        holder.setData(resource,title,description,price);
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

        }
        private void setData(String resource,String title,String description,String price) {
//            primg.setImageResource(resource);
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.img)).into(primg);
            prprice.setText("\u20b9 " + price + "/-");
            prdis.setText(description);
            prtitle.setText(title);

            if (!title.equals("")) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent pdIntent = new Intent(itemView.getContext(), ProductActivity.class);
                        itemView.getContext().startActivity(pdIntent);
                    }
                });
            }
        }
    }
}
