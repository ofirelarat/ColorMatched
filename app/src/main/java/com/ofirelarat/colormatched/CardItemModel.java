package com.ofirelarat.colormatched;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class CardItemModel {
    public static final Map<Integer,Integer> colorNameToValueIds = getColorsNamesToValueMap();

    private String meaningColorName;
    private String matchingColorName;
    private int meaningColorViewColor;
    private int matchingColorViewColor;
    private boolean isAMatch;

    public CardItemModel(Context context, int meaningColorName, int matchingColorName, int meaningColorViewColor, int matchingColorViewColor, boolean isAMatch) {
        this.meaningColorName = context.getResources().getString(meaningColorName);
        this.matchingColorName = context.getResources().getString(matchingColorName);
        this.meaningColorViewColor = context.getResources().getColor(meaningColorViewColor);
        this.matchingColorViewColor = context.getResources().getColor(matchingColorViewColor);
        this.isAMatch = isAMatch;
    }

    public static Map<Integer, Integer> getColorNameToValueIds() {
        return colorNameToValueIds;
    }

    public String getMeaningColorName() {
        return meaningColorName;
    }

    public void setMeaningColorName(String meaningColorName) {
        this.meaningColorName = meaningColorName;
    }

    public String getMatchingColorName() {
        return matchingColorName;
    }

    public void setMatchingColorName(String matchingColorName) {
        this.matchingColorName = matchingColorName;
    }

    public int getMeaningColorViewColor() {
        return meaningColorViewColor;
    }

    public void setMeaningColorViewColor(int meaningColorViewColor) {
        this.meaningColorViewColor = meaningColorViewColor;
    }

    public int getMatchingColorViewColor() {
        return matchingColorViewColor;
    }

    public void setMatchingColorViewColor(int matchingColorViewColor) {
        this.matchingColorViewColor = matchingColorViewColor;
    }

    public boolean isAMatch() {
        return isAMatch;
    }

    public void setAMatch(boolean AMatch) {
        isAMatch = AMatch;
    }

    private static Map<Integer, Integer> getColorsNamesToValueMap(){
        Map<Integer,Integer> colorsNamesToValue = new HashMap<>();
        colorsNamesToValue.put(R.string.black,R.color.black);
        colorsNamesToValue.put(R.string.blue,R.color.blue);
        colorsNamesToValue.put(R.string.green,R.color.green);
        colorsNamesToValue.put(R.string.orange,R.color.orange);
        colorsNamesToValue.put(R.string.red,R.color.red);

        return colorsNamesToValue;
    }

    public enum CardDifficalty{
        EASY,
        MEDIUM,
        HARD
    }
}
