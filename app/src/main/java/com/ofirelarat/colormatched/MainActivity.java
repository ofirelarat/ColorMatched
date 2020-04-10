package com.ofirelarat.colormatched;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardItemModel colorModel1 = new CardItemModel(this,R.string.black,R.string.blue,R.color.black,R.color.blue,false);
        CardItemModel colorModel2 = new CardItemModel(this,R.string.blue,R.string.blue,R.color.blue,R.color.blue,true);
        CardItemModel colorModel3 = new CardItemModel(this,R.string.green,R.string.green,R.color.black,R.color.green,true);
        CardItemModel colorModel4 = new CardItemModel(this,R.string.blue,R.string.orange,R.color.red,R.color.orange,false);
        CardItemModel colorModel5 = new CardItemModel(this,R.string.red,R.string.red,R.color.black,R.color.red,true);
        CardItemModel colorModel6 = new CardItemModel(this,R.string.orange,R.string.orange,R.color.orange,R.color.orange,true);

        CardItemModel[] colorsItems = {colorModel1, colorModel2, colorModel3, colorModel4, colorModel5,colorModel6};

        RecyclerView.Adapter cardsAdapter = new CardItemAdapter(colorsItems);
        CardStackLayoutManager manager = new CardStackLayoutManager(this, this);
        manager.setVisibleCount(3);
        manager.setStackFrom(StackFrom.Top);
        manager.setTranslationInterval(8f);
        manager.setScaleInterval(0.95f);
        manager.setMaxDegree(20f);
        manager.setSwipeThreshold(0.3f);
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        manager.setDirections(Direction.HORIZONTAL);


        CardStackView cardStackView = (CardStackView)findViewById(R.id.card_stack_view);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(cardsAdapter);
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

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
}
