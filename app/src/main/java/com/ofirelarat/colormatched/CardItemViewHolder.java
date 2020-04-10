package com.ofirelarat.colormatched;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardItemViewHolder extends RecyclerView.ViewHolder {
    TextView meaningColor;
    TextView matchingColorText;
    FrameLayout matchingColorCircle;

    public CardItemViewHolder(@NonNull View itemView) {
        super(itemView);

        meaningColor = itemView.findViewById(R.id.meaningColor);
        matchingColorText = itemView.findViewById(R.id.matchingColor);
        matchingColorCircle = itemView.findViewById(R.id.matchingColorCircle);
    }

    public void setUpDataInCard(CardItemModel cardItemModel){
        meaningColor.setText(cardItemModel.getMeaningColorName());
        matchingColorText.setText(cardItemModel.getMatchingColorName());
        ((GradientDrawable)matchingColorCircle.getBackground()).setColor(cardItemModel.getMatchingColorViewColor());
    }
}
