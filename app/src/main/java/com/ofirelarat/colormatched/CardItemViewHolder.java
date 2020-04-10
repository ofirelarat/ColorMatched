package com.ofirelarat.colormatched;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardItemViewHolder extends RecyclerView.ViewHolder {
    TextView meaningColor;
    TextView matchingColor;

    public CardItemViewHolder(@NonNull View itemView) {
        super(itemView);

        meaningColor = itemView.findViewById(R.id.meaningColor);
        matchingColor = itemView.findViewById(R.id.matchingColor);
    }

    public void setUpDataInCard(CardItemModel cardItemModel){
        meaningColor.setText(cardItemModel.getMeaningColorName());

        matchingColor.setText(cardItemModel.getMatchingColorName());
    }
}
