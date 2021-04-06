package com.santosh.vseeit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    private List<Wishlistmodel> wishlistmodelList;
    private Boolean wishlist;

    public WishlistAdapter(List<Wishlistmodel> wishlistmodelList, Boolean wishlist) {
        this.wishlistmodelList = wishlistmodelList;
        this.wishlist = wishlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String resource = wishlistmodelList.get(position).getProductimage();
    String title = wishlistmodelList.get(position).getProductTitle();
    long freecoupon = wishlistmodelList.get(position).getFreecoupon();
    String rating = wishlistmodelList.get(position).getRating();
    long totalrts = wishlistmodelList.get(position).getTtlrating();
    String pprice = wishlistmodelList.get(position).getProprice();
    String cprice = wishlistmodelList.get(position).getCutprice();
    boolean payment = wishlistmodelList.get(position).isCOD();
    holder.setData(resource,title,freecoupon,rating,totalrts,pprice,cprice,payment);

    }

    @Override
    public int getItemCount() {
        return wishlistmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView proimg;
        private TextView protitle;
        private TextView freecoupon;
        private ImageView couponicon;
        private TextView rating;
        private TextView ttlrating;
        private View pricecut;
        private TextView proprice;
        private TextView cutprice;
        private TextView paymentmethod;
        private ImageButton deletebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            proimg = itemView.findViewById(R.id.wish_img);
            protitle = itemView.findViewById(R.id.wish_title);
            freecoupon = itemView.findViewById(R.id.wish_coupn_txt);
            couponicon = itemView.findViewById(R.id.wish_coupn);
            rating = itemView.findViewById(R.id.tv_pro_rating_miniv);
            ttlrating = itemView.findViewById(R.id.total_rating);
            pricecut = itemView.findViewById(R.id.price_cut);
            proprice = itemView.findViewById(R.id.pro_price);
            cutprice = itemView.findViewById(R.id.cut_price);
            paymentmethod = itemView.findViewById(R.id.payment_method);
            deletebtn = itemView.findViewById(R.id.delete_btn);

        }
       private void setData(String resource, String title, long freecouponNo, String averageRate, long TotalRatingNo, String price, String cuttedpriceValue,boolean COD) {
           //      proimg.setImageResource(resource);
           Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.img)).into(proimg);
           protitle.setText(title);
           if (freecouponNo != 0) {
               couponicon.setVisibility(View.VISIBLE);
               if (freecouponNo == 1) {
                   freecoupon.setText("Free " + freecouponNo + " coupon");
               } else {
                   freecoupon.setText("Free " + freecouponNo + " coupons");
               }
           } else {
               couponicon.setVisibility(View.INVISIBLE);
               couponicon.setVisibility(View.INVISIBLE);
           }
           rating.setText(averageRate);
           ttlrating.setText(TotalRatingNo + "(ratings)");
           proprice.setText("\u20b9 "+price+"/-");
           cutprice.setText("\u20b9 "+cuttedpriceValue+"/-");
           if (COD){
               paymentmethod.setVisibility(View.VISIBLE);
             }else{
               paymentmethod.setVisibility(View.INVISIBLE);
             }
            if (wishlist){
                deletebtn.setVisibility(View.VISIBLE);
            }else{
                deletebtn.setVisibility(View.GONE);

            }
            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetails = new Intent(itemView.getContext(),ProductActivity.class);
                    itemView.getContext().startActivity(productDetails);
                }
            });
        }
    }
}
