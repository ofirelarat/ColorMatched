package com.ofirelarat.colormatched;

import android.content.Context;
import android.view.contentcapture.ContentCaptureCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardItemModel {
    public static final Map<Integer,Integer> colorNameToValueIds = getColorsNamesToValueMap();

    private String meaningColorName;
    private String matchingColorName;
    private int meaningColorViewColor;
    private int matchingColorViewColor;
    private boolean isAMatch;

    public CardItemModel(){ }

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

    public void setMeaningColorName(Context context, int meaningColorName) {
        this.meaningColorName = context.getResources().getString(meaningColorName);
    }

    public String getMatchingColorName() {
        return matchingColorName;
    }

    public void setMatchingColorName(Context context, int matchingColorName) {
        this.matchingColorName = context.getResources().getString(matchingColorName);
    }

    public int getMeaningColorViewColor() {
        return meaningColorViewColor;
    }

    public void setMeaningColorViewColor(Context context, int meaningColorViewColor) {
        this.meaningColorViewColor = context.getResources().getColor(meaningColorViewColor);
    }

    public int getMatchingColorViewColor() {
        return matchingColorViewColor;
    }

    public void setMatchingColorViewColor(Context context, int matchingColorViewColor) {
        this.matchingColorViewColor = context.getResources().getColor(matchingColorViewColor);
    }

    public boolean isAMatch() {
        return isAMatch;
    }

    public void setAMatch(boolean AMatch) {
        isAMatch = AMatch;
    }

    public static CardItemModel getRandomizeCard(Context context){
        CardItemModel cardItemModel = new CardItemModel();

        Random random =new Random();
        final int colorsCount = colorNameToValueIds.size();

        int randomColor = random.nextInt(colorsCount);
        int randomColorRes = getRandomColorRes(randomColor);
        cardItemModel.setMeaningColorName(context, randomColorRes);
        cardItemModel.setMeaningColorViewColor(context, colorNameToValueIds.get(randomColorRes));

        boolean isAMatch = random.nextBoolean();
        cardItemModel.setAMatch(isAMatch);
        if(isAMatch){
            cardItemModel.setMatchingColorName(context, randomColorRes);
            cardItemModel.setMatchingColorViewColor(context, colorNameToValueIds.get(randomColorRes));
        }else {
            int randomMatchColor = random.nextInt(colorsCount);
            int randomMatchColorRes = getRandomColorRes(randomMatchColor);
            cardItemModel.setMatchingColorName(context, randomMatchColorRes);
            cardItemModel.setMatchingColorViewColor(context, colorNameToValueIds.get(randomMatchColorRes));
        }

        return cardItemModel;
    }

    private static int getRandomColorRes(int randomInx){
        switch (randomInx){
            case 0:
                return R.string.black;
            case 1:
                return R.string.blue;
            case 2:
                return R.string.green;
            case 3:
                return R.string.orange;
            case 4:
                return R.string.red;
            default:
                return R.string.black;
        }
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
