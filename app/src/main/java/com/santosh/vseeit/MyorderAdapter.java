package com.santosh.vseeit;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyorderAdapter extends RecyclerView.Adapter<MyorderAdapter.Viewholder> {
    private List<MyOrderItemModel> myOrderItemModelList;

    public MyorderAdapter(List<MyOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public MyorderAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_orders_item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyorderAdapter.Viewholder holder, int position) {
int resource = myOrderItemModelList.get(position).getProductimage();
int rating = myOrderItemModelList.get(position).getRating();
String title = myOrderItemModelList.get(position).getProuducttitle();
String deliverdate = myOrderItemModelList.get(position).getDeliverystatus();
holder.setData(resource,title,deliverdate,rating);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        private ImageView orderimg;
        private ImageView orderindi;
        private TextView ordertitle;
        private TextView deliverystatus;
        private LinearLayout ratenow;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            orderimg = itemView.findViewById(R.id.order_imagu);
            ordertitle = itemView.findViewById(R.id.order_title);
            orderindi = itemView.findViewById(R.id.order_indicator);
            deliverystatus = itemView.findViewById(R.id.order_deliver_date);
            ratenow = itemView.findViewById(R.id.rate_str_5);
        }

        private void setData(int resource, String title, String deliverydate, int rating) {
            orderimg.setImageResource(resource);
            ordertitle.setText(title);
            if (deliverydate.equals("Cancelled")) {
                orderindi.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimary)));
            } else {
                orderindi.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.yellow)));
            }
            deliverystatus.setText(deliverydate);

            ///////rating layout
            setRating(rating);
            for (int x = 0; x < ratenow.getChildCount(); x++) {
                final int starposition = x;
                ratenow.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(starposition);
                    }
                });
            }
        }
        private void setRating(int starposition) {
            for (int s = 0; s < ratenow.getChildCount(); s++) {
                ImageView strbtn = (ImageView) ratenow.getChildAt(s);
                strbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
                if (s <= starposition) {
                    strbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFBF00")));
                }
            }
        }
        ///////rating layout
    }
}