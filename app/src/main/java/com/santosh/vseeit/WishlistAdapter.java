package com.santosh.vseeit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    public WishlistAdapter(List<Wishlistmodel> wishlistmodelList) {
        this.wishlistmodelList = wishlistmodelList;
    }

    private List<Wishlistmodel> wishlistmodelList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    int resource = wishlistmodelList.get(position).getProductimage();
    String title = wishlistmodelList.get(position).getProductTitle();
    int freecoupon = wishlistmodelList.get(position).getFreecoupon();
    String rating = wishlistmodelList.get(position).getRating();
    int totalrts = wishlistmodelList.get(position).getTtlrating();
    String pprice = wishlistmodelList.get(position).getProprice();
    String cprice = wishlistmodelList.get(position).getCutprice();
    String payment = wishlistmodelList.get(position).getPaymentmethod();
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
       private void setData(int resource, String title, int freecouponNo, String averageRate, int TotalRatingNo, String price, String cuttedpriceValue, String paymentNo){
            proimg.setImageResource(resource);
            protitle.setText(title);
            if (freecouponNo != 0) {
                couponicon.setVisibility(View.VISIBLE);
                if (freecouponNo == 1) {
                    freecoupon.setText("Free " + freecouponNo + " coupon");
                } else {
                    freecoupon.setText("Free " + freecouponNo + " coupons");
                }
            }else {
                couponicon.setVisibility(View.INVISIBLE);
                couponicon.setVisibility(View.INVISIBLE);
            }
            rating.setText(averageRate);
            ttlrating.setText(TotalRatingNo+"(ratings)");
            proprice.setText(price);
            cutprice.setText(cuttedpriceValue);
            paymentmethod.setText(paymentNo);
            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
