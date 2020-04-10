package com.ofirelarat.colormatched;

public class CardItemModel {
    private String meaningColorName;
    private String matchingColorName;
    private String meaningColorColor;
    private String matchingColorColor;
    private boolean isAMatch;

    public CardItemModel(String meaningColorName, String matchingColorName, String meaningColorColor, String matchingColorColor, boolean isAMatch) {
        this.meaningColorName = meaningColorName;
        this.matchingColorName = matchingColorName;
        this.meaningColorColor = meaningColorColor;
        this.matchingColorColor = matchingColorColor;
        this.isAMatch = isAMatch;
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

    public String getMeaningColorColor() {
        return meaningColorColor;
    }

    public void setMeaningColorColor(String meaningColorColor) {
        this.meaningColorColor = meaningColorColor;
    }

    public String getMatchingColorColor() {
        return matchingColorColor;
    }

    public void setMatchingColorColor(String matchingColorColor) {
        this.matchingColorColor = matchingColorColor;
    }

    public boolean isAMatch() {
        return isAMatch;
    }

    public void setAMatch(boolean AMatch) {
        isAMatch = AMatch;
    }
}
