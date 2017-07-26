package com.longyuan.restapitest.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longyuan.restapitest.R;
import com.longyuan.restapitest.data.Promotion;

import java.util.List;

/**
 * Created by loxu on 26/07/2017.
 */

public class PromotionsRecyclerViewAdapter extends RecyclerView.Adapter<PromotionsRecyclerViewAdapter.PromotionViewHolder> {

    private List<Promotion> mPromotions;



    public PromotionsRecyclerViewAdapter(List<Promotion> promotionList){

        mPromotions = promotionList;

    }


    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promotion_item, parent, false);


        return new PromotionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {

        final Promotion promotion = mPromotions.get(position);

        holder.mTextViewId.setText(promotion.getId());

        holder.mTextViewTitle.setText(promotion.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPromotions.size();
    }

    public void replaceData(List<Promotion> promotionList){
        mPromotions = promotionList;

        notifyDataSetChanged();
    }

    public static class PromotionViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewId;

        TextView mTextViewTitle;


        public PromotionViewHolder(View itemView) {
            super(itemView);

            mTextViewId  = (TextView) itemView.findViewById(R.id.promotion_item_id);

            mTextViewTitle = (TextView) itemView.findViewById(R.id.promotion_item_title);

        }
    }
}
