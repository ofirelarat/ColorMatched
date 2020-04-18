package com.ofirelarat.colormatched;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AhoyOnboarderActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard(
                "Is it a match?",
                "Check if the color name and color are match",
                R.drawable.colors_matched_screen1);
        ahoyOnboarderCard1.setIconLayoutParams(550, 750, 60, 25, 25, 100);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard(
                "now swipe!",
                "If it's true swipe right other wise swipe left",
                R.drawable.colors_matched_screen2);
        ahoyOnboarderCard2.setIconLayoutParams(550, 750, 60, 25, 25, 100);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard(
                "too easy?",
                "To disturb you, the color name may have color and the color may have name that not related",
                R.drawable.colors_matched_screen3);
        ahoyOnboarderCard3.setIconLayoutParams(450, 650, 60, 25, 25, 100);

        List<AhoyOnboarderCard> onboardingPages = new ArrayList<AhoyOnboarderCard>();
        onboardingPages.add(ahoyOnboarderCard1);
        onboardingPages.add(ahoyOnboarderCard2);
        onboardingPages.add(ahoyOnboarderCard3);

        setGradientBackground();
        setOnboardPages(onboardingPages);
    }

    @Override
    public void onFinishButtonPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
