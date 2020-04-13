package com.ofirelarat.colormatched;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private RecyclerView.Adapter cardsAdapter;
    private CardStackLayoutManager manager;
    private CardStackView cardStackView;

    private TextView scoreText;
    private CircularView progressBar;

    private CardItemModel[] colorsItems;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStackView = (CardStackView)findViewById(R.id.card_stack_view);
        scoreText = findViewById(R.id.scoreText);
        progressBar = findViewById(R.id.circular_view);

        colorsItems = getColorsItems();
        initCardStackView();
        initTimerView();
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {
        CardItemModel swipedCard = colorsItems[manager.getTopPosition() - 1];
        Log.d("card swiped", swipedCard.isAMatch() + " " + direction);
        if((swipedCard.isAMatch() && direction == Direction.Right)
                || ((!swipedCard.isAMatch()) && direction == Direction.Left)){
            Toast.makeText(MainActivity.this, "correct!", Toast.LENGTH_LONG).show();
            score += 10 * (swipedCard.getDifficultyLevel().ordinal() + 1);
            scoreText.setText(String.valueOf(score));
        }else{
            Toast.makeText(MainActivity.this, "error!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }

    public void onClickIncorrectBtn(View view) {
        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Slow.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();
        manager.setSwipeAnimationSetting(setting);
        cardStackView.swipe();
    }

    public void onClickCorrectBtn(View view) {
        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Slow.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();
        manager.setSwipeAnimationSetting(setting);
        cardStackView.swipe();
    }

    private void initCardStackView(){
        cardsAdapter = new CardItemAdapter(colorsItems);

        manager = new CardStackLayoutManager(this, this);
        manager.setVisibleCount(3);
        manager.setStackFrom(StackFrom.Top);
        manager.setTranslationInterval(8f);
        manager.setScaleInterval(0.90f);
        manager.setMaxDegree(20f);
        manager.setSwipeThreshold(0.3f);
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        manager.setDirections(Direction.HORIZONTAL);

        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(cardsAdapter);
    }

    private void initTimerView() {
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(60)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {
                                // Will be called if times up of countdown timer
                                Toast.makeText(MainActivity.this, "Timer Finished ", Toast.LENGTH_SHORT).show();
                                displayEndGameDialog();
                            }

                            @Override
                            public void onTimerCancelled() {
                                // Will be called if stopTimer is called
                                Toast.makeText(MainActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });

        progressBar.setOptions(builderWithTimer);
        progressBar.startTimer();
    }

    private CardItemModel[] getColorsItems(){
        CardItemModel[] cardItemModels = new CardItemModel[50];
        for (int i = 0; i<cardItemModels.length; i++) {
            if(i < 4){
                cardItemModels[i] = CardItemModel.getRandomizeCardWithDefaultLevel(this, CardItemModel.CardDifficulty.EASY);
            }else {
                cardItemModels[i] = CardItemModel.getRandomizeCard(this);
            }
        }

        return cardItemModels;
    }

    private void displayEndGameDialog(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Game Over")
                .setMessage("your score is: " + score + ", would you like to play again?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetGame();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void resetGame(){
        score = 0;
        scoreText.setText(String.valueOf(score));
        colorsItems = getColorsItems();
        cardsAdapter = new CardItemAdapter(colorsItems);
        cardStackView.setAdapter(cardsAdapter);
        initTimerView();
    }
}
