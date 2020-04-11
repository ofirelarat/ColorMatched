package com.ofirelarat.colormatched;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private RecyclerView.Adapter cardsAdapter;
    private CardStackLayoutManager manager;
    private CardItemModel[] colorsItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorsItems = getColorsItems();

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


        CardStackView cardStackView = (CardStackView)findViewById(R.id.card_stack_view);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(cardsAdapter);
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

    private CardItemModel[] getColorsItems(){
        CardItemModel[] cardItemModels = new CardItemModel[6];
        cardItemModels[0] = new CardItemModel(this,R.string.black,R.string.blue,R.color.black,R.color.blue,false);
        cardItemModels[1] = new CardItemModel(this,R.string.blue,R.string.blue,R.color.blue,R.color.blue,true);
        cardItemModels[2] = new CardItemModel(this,R.string.green,R.string.green,R.color.black,R.color.green,true);
        cardItemModels[3] = new CardItemModel(this,R.string.blue,R.string.orange,R.color.red,R.color.orange,false);
        cardItemModels[4] = new CardItemModel(this,R.string.red,R.string.red,R.color.black,R.color.red,true);
        cardItemModels[5] = new CardItemModel(this,R.string.orange,R.string.orange,R.color.orange,R.color.orange,true);

        return cardItemModels;
    }
}
