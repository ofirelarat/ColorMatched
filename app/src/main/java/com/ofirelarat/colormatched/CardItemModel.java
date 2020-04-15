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
    private CardDifficulty difficultyLevel;

    public CardItemModel(){ }

    public CardItemModel(Context context, int meaningColorName, int matchingColorName, int meaningColorViewColor, int matchingColorViewColor, boolean isAMatch, CardDifficulty difficultyLevel) {
        this.meaningColorName = context.getResources().getString(meaningColorName);
        this.matchingColorName = context.getResources().getString(matchingColorName);
        this.meaningColorViewColor = context.getResources().getColor(meaningColorViewColor);
        this.matchingColorViewColor = context.getResources().getColor(matchingColorViewColor);
        this.isAMatch = isAMatch;
        this.difficultyLevel = difficultyLevel;
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

    public CardDifficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(CardDifficulty difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public static CardItemModel getRandomizeCard(Context context){
        Random random = new Random();
        CardDifficulty randomCardDifficultLevel = CardDifficulty.values()[random.nextInt(3)];
        CardItemModel cardItemModel = getRandomizeCardWithDefaultLevel(context, randomCardDifficultLevel);

        return cardItemModel;
    }


    public static CardItemModel getRandomizeCardWithDefaultLevel(Context context, CardDifficulty difficultyLevel){
        CardItemModel cardItemModel = new CardItemModel();

        Random random =new Random();
        final int colorsCount = colorNameToValueIds.size();

        int randomColor = random.nextInt(colorsCount);
        int randomColorRes = getRandomColorRes(randomColor);
        cardItemModel.setMeaningColorName(context, randomColorRes);

        boolean isAMatch = random.nextBoolean();
        cardItemModel.setAMatch(isAMatch);
        if(isAMatch){
            cardItemModel.setMatchingColorViewColor(context, colorNameToValueIds.get(randomColorRes));
        }else {
            int randomMatchColor = random.nextInt(colorsCount);
            int randomMatchColorRes = getRandomColorRes(randomMatchColor);
            cardItemModel.setMatchingColorViewColor(context, colorNameToValueIds.get(randomMatchColorRes));
            if(randomColor == randomMatchColor){
                cardItemModel.setAMatch(true);
            }
        }

        cardItemModel.setDifficultyLevel(difficultyLevel);
        switch (difficultyLevel){
            case HARD:
                int randomColorHard = random.nextInt(colorsCount);
                int randomMeaningColorResHard = getRandomColorRes(randomColorHard);
                cardItemModel.setMeaningColorViewColor(context, colorNameToValueIds.get(randomMeaningColorResHard));
                randomColorHard = random.nextInt(colorsCount);
                int randomMatchingColorResHard = getRandomColorRes(randomColorHard);
                cardItemModel.setMatchingColorName(context, randomMatchingColorResHard);
                break;
            case MEDIUM:
                cardItemModel.setMeaningColorViewColor(context, R.color.black);
                int randomColorMedium = random.nextInt(colorsCount);
                int randomMatchColorResMedium = getRandomColorRes(randomColorMedium);
                cardItemModel.setMatchingColorName(context, randomMatchColorResMedium);
                break;
            case EASY:
                cardItemModel.setMeaningColorViewColor(context, R.color.black);
                break;
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
            case 5:
                return R.string.yellow;
            case 6:
                return R.string.purple;
            case 7:
                return R.string.pink;
            case 8:
                return R.string.gray;
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
        colorsNamesToValue.put(R.string.yellow,R.color.yellow);
        colorsNamesToValue.put(R.string.purple,R.color.purple);
        colorsNamesToValue.put(R.string.pink,R.color.pink);
        colorsNamesToValue.put(R.string.gray,R.color.gray);

        return colorsNamesToValue;
    }

    public enum CardDifficulty{
        EASY,
        MEDIUM,
        HARD
    }
}
