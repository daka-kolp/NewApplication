package com.dakakolp.newapplication.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dakakolp.newapplication.R;
import com.dakakolp.newapplication.ui.adapters.models.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> mItemList;
    private CardViewListener mCardViewListener;

    public interface CardViewListener{
        void onClickCardView(int position);
    }

    public ItemAdapter(List<Item> itemList, CardViewListener cardViewListener) {
        mItemList = itemList;
        mCardViewListener = cardViewListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list_item, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = mItemList.get(position);
        Picasso.get()
                .load(item.getImage())
                .into(holder.mImageItem);
        holder.mTitle.setText(item.getTitle());
        holder.mSubtitle.setText(item.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private ImageView mImageItem;
        private TextView mTitle;
        private TextView mSubtitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view_item);
            mImageItem = itemView.findViewById(R.id.image_item);
            mTitle = itemView.findViewById(R.id.title_item);
            mSubtitle = itemView.findViewById(R.id.subtitle_item);

            mCardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mCardViewListener.onClickCardView(getAdapterPosition());
                }
            });

        }
    }
}



