package com.example.rohit.swipeprototype;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;

/**
 * Created by Rohit on 08/10/15.
 */
public class CardContainer extends AdapterViewAnimator {

    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    private Adapter adapter;

    public CardContainer(Context context) {
        super(context);
    }

    public CardContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CardContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
//
//    @Override
//    public Adapter getAdapter() {
//        return null;
//    }
//
//    @Override
//    public void setAdapter(Adapter adapter) {
//        this.adapter = adapter;
//    }
//
//    @Override
//    public View getSelectedView() {
//        return null;
//    }
//
//    @Override
//    public void setSelection(int position) {
//
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                x1 = event.getX();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2 = event.getX();
//                float deltaX = x2 - x1;
//
//                if (Math.abs(deltaX) > MIN_DISTANCE) {
//                    // Left to Right swipe action
//                    if (x2 > x1) {
////                        Toast.makeText(context, "Left to Right swipe [Next]", Toast.LENGTH_SHORT).show ();
//                        Log.v("LimitSwipeStackView", "Left to Right swipe [Next]");
//                        showNext();
//                        return true;
//                    }
//
//                    // Right to left swipe action
//                    else {
////                        Toast.makeText(context, "Right to Left swipe [Previous]", Toast.LENGTH_SHORT).show ();
//                        Log.v("LimitSwipeStackView", " Right to Left swipe [Previous]");
//                        showPrevious();
//                        return true;
//                    }
//
//                } else {
//                    // consider as something else - a screen tap for example
//                    Log.v("LimitSwipeStackView", " Else event");
//                    return false;
//
//                }
////                        break;
//        }
//        return super.onTouchEvent(event);
//    }
}
