package com.ofirelarat.colormatched;

import androidx.annotation.NonNull;

public class LangItem {
    private  String langCode;
    private int flagUnicodePart1;
    private int flagUnicodePart2;
    private String title;

    public LangItem(String langCode, int flagUnicodePart1, int flagUnicodePart2, String title) {
        this.langCode = langCode;
        this.flagUnicodePart1 = flagUnicodePart1;
        this.flagUnicodePart2 = flagUnicodePart2;
        this.title = title;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public int getFlagUnicodePart1() {
        return flagUnicodePart1;
    }

    public void setFlagUnicodePart1(int flagUnicodePart1) {
        this.flagUnicodePart1 = flagUnicodePart1;
    }

    public int getFlagUnicodePart2() {
        return flagUnicodePart2;
    }

    public void setFlagUnicodePart2(int flagUnicodePart2) {
        this.flagUnicodePart2 = flagUnicodePart2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return new String(Character.toChars(this.flagUnicodePart1)) + new String(Character.toChars(this.flagUnicodePart2)) +  " " + title;
    }
}
