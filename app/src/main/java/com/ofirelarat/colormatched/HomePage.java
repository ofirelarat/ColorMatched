package com.ofirelarat.colormatched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final LangItem[] langs = getLangs();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,getLangsText(langs));
        Spinner langsSpinner = findViewById(R.id.langsSpinner);
        langsSpinner.setAdapter(adapter);
        langsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Resources res = HomePage.this.getResources();
                DisplayMetrics displayMetrics = res.getDisplayMetrics();
                android.content.res.Configuration configuration = res.getConfiguration();
                configuration.setLocale(new Locale(langs[i].getLangCode()));
                res.updateConfiguration(configuration, displayMetrics);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SharedPreferencesMgr sharedPreferencesMgr = new SharedPreferencesMgr(this);
        ((TextView)findViewById(R.id.scoreText)).setText(String.valueOf(sharedPreferencesMgr.getHighScore()));
    }


    public void onClickStartClassic(View view) {
    }

    public void onClickStartArcade(View view) {
        Intent intent = new Intent(this, OnboardingActivity.class);
        startActivity(intent);
    }

    public void onClickLeaderBoard(View view) {
    }

    private LangItem[] getLangs(){
        LangItem hebrew = new LangItem("he", 0x1F1EE, 0x1F1F1, "Hebrew");
        LangItem english = new LangItem("en", 0x1F1FA, 0x1F1F8, "english");
        LangItem spanish = new LangItem("es", 0x1F1EA, 0x1F1F8, "spanish");

        return new LangItem[]{english, spanish, hebrew};
    }

    private String[] getLangsText(LangItem[] langItems){
        String[] langTitles = new String[langItems.length];
        for (int i=0;i<langTitles.length;i++) {
            langTitles[i] = langItems[i].toString();
        }

        return langTitles;
    }
}
