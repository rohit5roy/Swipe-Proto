package com.koove;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.StackView;

/**
 * Created by Rohit on 08/10/15.
 * @deprecated
 **/

public class LimitSwipeStackView extends StackView {

    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    private Context context;

    public LimitSwipeStackView(Context context) {
        super(context);
        this.context = context;
    }

    public LimitSwipeStackView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LimitSwipeStackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LimitSwipeStackView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
////        if(ev == MotionEvent.)
//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                x1 = event.getX();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2 = event.getX();
//                float deltaX = x2 - x1;
//
//                if (Math.abs(deltaX) > MIN_DISTANCE)
//                {
//                    // Left to Right swipe action
//                    if (x2 > x1)
//                    {
////                        Toast.makeText(context, "Left to Right swipe [Next]", Toast.LENGTH_SHORT).show ();
//                        Log.v("LimitSwipeStackView", "Left to Right swipe [Next]" );
//                        this.showNext();
//                    }
//
//                    // Right to left swipe action
//                    else
//                    {
////                        Toast.makeText(context, "Right to Left swipe [Previous]", Toast.LENGTH_SHORT).show ();
//                        Log.v("LimitSwipeStackView", " Right to Left swipe [Previous]" );
//                        this.showPrevious();
//                    }
//
//                }
//                else
//                {
//                    // consider as something else - a screen tap for example
//                    Log.v("LimitSwipeStackView", " Else event" );
//
//                }
//                break;
//        }
//        return super.onTouchEvent(event);
//    }

}
