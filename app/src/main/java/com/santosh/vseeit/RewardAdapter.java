package com.santosh.vseeit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.Viewholder> {
    private List<RewardModel> rewardModelList;
    private Boolean useMinilayout = false;

    public RewardAdapter(List<RewardModel> rewardModelList, Boolean useMinilayout) {
        this.rewardModelList = rewardModelList;
        this.useMinilayout = useMinilayout;
    }

    @NonNull
    @Override
    public RewardAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (useMinilayout) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_rewards_item, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reward_item, parent, false);
        }
            return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardAdapter.Viewholder holder, int position) {
    String title = rewardModelList.get(position).getTitle();
    String date = rewardModelList.get(position).getExpriydate();
    String body = rewardModelList.get(position).getCouponbody();
    holder.setData(title,date,body);
    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView rewardtitle;
        private TextView expirydate;
        private TextView couponbody;
        public Viewholder(@NonNull final View itemView) {
            super(itemView);
            rewardtitle = itemView.findViewById(R.id.rew);
            expirydate = itemView.findViewById(R.id.reward_date);
            couponbody = itemView.findViewById(R.id.reward_offer);
        }
        public void setData(final String titleValue, final String dateValue, final String bodyValue){
            rewardtitle.setText(titleValue);
            expirydate.setText(dateValue);
            couponbody.setText(bodyValue);

            if (useMinilayout){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ProductActivity.coupontitle.setText(titleValue);
                        ProductActivity.couponexdate.setText(dateValue);
                        ProductActivity.couponbody.setText(bodyValue);
                    }
                });
            }
        }
    }
}
