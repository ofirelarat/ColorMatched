package com.ofirelarat.colormatched;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardItemAdapter extends  RecyclerView.Adapter{
    private Context context;
    private CardItemModel[] cards;

    public CardItemAdapter(CardItemModel[] cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.card_item, null, false);

        CardItemViewHolder cardItemViewHolder = new CardItemViewHolder(view);

        return cardItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CardItemViewHolder)holder).setUpDataInCard(cards[position]);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return this.cards.length;
    }
}
