package com.ofirelarat.colormatched;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesMgr {
    private SharedPreferences sharedPreferences;
    private final String SHARED_PREFERENCES_FILE_NAME = "com.ofirelarat.colormatched.shared_preferences";
    private final String SHARED_PREFERENCES_HIGH_SCORE_KEY = "high_scores";

    public SharedPreferencesMgr(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }

    public boolean writeNewScoerifIsHigher(int newScore){
        int oldHighScore = sharedPreferences.getInt(SHARED_PREFERENCES_HIGH_SCORE_KEY, 0);
        if(oldHighScore < newScore) {
            sharedPreferences.edit().putInt(SHARED_PREFERENCES_HIGH_SCORE_KEY, newScore).commit();

            return true;
        }

        return false;
    }

    public int getHighScore(){
        return sharedPreferences.getInt(SHARED_PREFERENCES_HIGH_SCORE_KEY, 0);
    }
}
