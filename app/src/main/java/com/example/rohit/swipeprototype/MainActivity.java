package com.example.rohit.swipeprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.koove.CardContainer;
import com.koove.OnSwipeTouchListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
//        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static final String TAG = "SwipeProto";
    private ImageView mImageView;
    private ViewGroup mRrootLayout;
    private int _xDelta;
    private int _yDelta;
    private CardStackAdapter stackAdapter;
    private CardContainer cardContainer;
    OnSwipeTouchListener onSwipeTouchListener;

    FrameLayout mainLayer;
    View layer1, layer2, layer3;
    Animation slideInRight, slideInLeft, slideOutLeft;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayer = (FrameLayout)findViewById(R.id.root);
        cardContainer = (com.koove.CardContainer) findViewById(R.id.stack);
        String [] arr = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        stackAdapter = new CardStackAdapter(this,R.layout.layer, Arrays.asList(arr));

        cardContainer.setAdapter(stackAdapter);
        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_right);
        slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_left);
        slideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_from_left);


      /*  onSwipeTouchListener = new OnSwipeTouchListener(MainActivity.this) {
            int pos = position;

            @Override
            public void onSwipeLeft() {
                ((AdapterViewAnimator) parent).showNext();
            }

            @Override
            public void onSwipeRight() {
                ((AdapterViewAnimator) parent).showPrevious();
            }

            @Override
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "Swiped towards Top", Toast.LENGTH_SHORT).show();
            }


        };*/

        onSwipeTouchListener = new OnSwipeTouchListener(this){

            @Override
            public void onSwipeRight() {
                stackAdapter.onSwipeRight();
            }

            @Override
            public void onSwipeLeft() {
                stackAdapter.onSwipeLeft();
            }

            @Override
            public void onSwipeTop() {
                stackAdapter.onSwipeTop();
            }

            @Override
            public void onSwipeBottom() {
                stackAdapter.onSwipeTop();
            }

        };

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        onSwipeTouchListener.getGestureDetector().onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    public View.OnTouchListener getSwipeOnTouchListener(){
        return onSwipeTouchListener;
    }

}
