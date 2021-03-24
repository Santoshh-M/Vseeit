package com.santosh.vseeit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartitemModel> cartitemModelList;

    public CartAdapter(List<CartitemModel> cartitemModelList) {
        this.cartitemModelList = cartitemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartitemModelList.get(position).getType()) {
            case 0:
                return CartitemModel.CART_ITEM;
            case 1:
                return CartitemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case CartitemModel.CART_ITEM:
                View cartitemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
                return new cartItemViewholder(cartitemView);
            case CartitemModel.TOTAL_AMOUNT:
                View cartAmount = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_ttl_amt_lyt, parent, false);
                return new cartTotalAmountviewholder(cartAmount);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    switch (cartitemModelList.get(position).getType()){
        case CartitemModel.CART_ITEM:
            int resource = cartitemModelList.get(position).getProductimg();
            String title = cartitemModelList.get(position).getProductTitle();
            int frecoupon = cartitemModelList.get(position).getFreecoupon();
            String proprice = cartitemModelList.get(position).getProductprice();
            String cutprice = cartitemModelList.get(position).getCuttedprice();
            int ofrapplied = cartitemModelList.get(position).getOffrapplied();
            int couponapplied = cartitemModelList.get(position).getCoupnapplied();
            ((cartItemViewholder)holder).setItemDetails(resource,title,frecoupon,proprice,cutprice,ofrapplied,couponapplied);
        break;
        case CartitemModel.TOTAL_AMOUNT:
            String ttlitm = cartitemModelList.get(position).getTotalItems();
            String ttlitmprice = cartitemModelList.get(position).getTtlitmprice();
            String deliver = cartitemModelList.get(position).getDelivercrg();
            String  ttlamount = cartitemModelList.get(position).getTotalamount();
            String saved = cartitemModelList.get(position).getSavedamt();

            ((cartTotalAmountviewholder)holder).setTotalamt(ttlitm,ttlitmprice,deliver,ttlamount,saved);
            break;
        default:
            return;
    }

    }

    @Override
    public int getItemCount() {
        return cartitemModelList.size();
    }

public class cartItemViewholder extends RecyclerView.ViewHolder {
        private ImageView proimg;
        private ImageView freecouponicon;
        private TextView protitle;
        private TextView freecoupon;
        private TextView productprice;
        private TextView cuttedprice;
        private TextView offrapplied;
        private TextView coupnapplied;
        private TextView proqtty;


        public cartItemViewholder(@NonNull View itemView) {
            super(itemView);
            proimg = itemView.findViewById(R.id.pro_img);
            productprice = itemView.findViewById(R.id.prop_price);
            protitle = itemView.findViewById(R.id.pro_title);
            proqtty = itemView.findViewById(R.id.pro_quantity);
            freecouponicon = itemView.findViewById(R.id.free_coupon);
            freecoupon = itemView.findViewById(R.id.tv_coupon);
            cuttedprice = itemView.findViewById(R.id.cutting_price);
            offrapplied = itemView.findViewById(R.id.offers_spl);
            coupnapplied = itemView.findViewById(R.id.couponapplied);

        }
        private void setItemDetails(int resource, String title, int freecouponNo, String productpriceText, String cuttedpriceText, int offrappliedNo, int couponapplied) {
            proimg.setImageResource(resource);
            protitle.setText(title);
            productprice.setText(productpriceText);
            cuttedprice.setText(cuttedpriceText);
            if (freecouponNo > 0) {
                freecouponicon.setVisibility(View.VISIBLE);
                freecoupon.setVisibility(View.VISIBLE);
                    if (freecouponNo == 1) {
                        freecoupon.setText("Free " + freecouponNo + " Coupon");
                    }   else {
                        freecoupon.setText("Free " + freecouponNo + " Coupon");
                    }
            }else {
                freecouponicon.setVisibility(View.INVISIBLE);
                freecoupon.setVisibility(View.INVISIBLE);
            }
                if (offrappliedNo > 0){
                    offrapplied.setVisibility(View.VISIBLE);
                    offrapplied.setText(offrappliedNo + " offers applied");
                } else {
                    offrapplied.setVisibility(View.INVISIBLE);
                }
            if (couponapplied > 0){
                coupnapplied.setVisibility(View.VISIBLE);
                coupnapplied.setText(couponapplied + " Coupons are applied");
            } else {
                coupnapplied.setVisibility(View.INVISIBLE);
            }

            }
        }

       public class cartTotalAmountviewholder extends RecyclerView.ViewHolder {
            private TextView totalitms;
            private TextView totalitmprice;
            private TextView deliverycrg;
            private TextView totalamt;
            private TextView saveamt;
            public cartTotalAmountviewholder(@NonNull View itemView) {
                super(itemView);

                totalitms = (TextView)itemView.findViewById(R.id.ttl_items);
                totalitmprice = (TextView)itemView.findViewById(R.id.ttl_item_price);
                deliverycrg =(TextView) itemView.findViewById(R.id.delivery_chrg);
                totalamt = (TextView)itemView.findViewById(R.id.ttl_price);
                saveamt = (TextView)itemView.findViewById(R.id.saved_amount);
            }
            private void setTotalamt(String ttlitmtxt, String ttlitmpritxt, String deltxt, String ttltxt, String savetxt){
                totalitms.setText(ttlitmtxt);
                totalitmprice.setText(ttlitmpritxt);
                deliverycrg.setText(deltxt);
                totalamt.setText(ttltxt);
                saveamt.setText(savetxt);

            }
        }
    }
