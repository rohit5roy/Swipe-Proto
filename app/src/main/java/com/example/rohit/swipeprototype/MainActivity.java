package com.example.rohit.swipeprototype;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static final String TAG = "SwipeProto";
    private ImageView mImageView;
    private ViewGroup mRrootLayout;
    private int _xDelta;
    private int _yDelta;
    private StackView stackView;

    FrameLayout mainLayer;
    View layer1, layer2, layer3;
    Animation slideInRight, slideInLeft, slideOutLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mRrootLayout = (ViewGroup) findViewById(R.id.root);
//        mImageView = (ImageView) findViewById(R.id.imageView2);

        mainLayer = (FrameLayout)findViewById(R.id.root);
        stackView = (StackView) findViewById(R.id.stack);
        LayoutTransition transition = new LayoutTransition();
//        transition.set

//        stackView.seta

        slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_right);
        slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_left);
        slideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_from_left);

        LayoutInflater inflater = getLayoutInflater();
        layer1 = inflater.inflate(R.layout.layer, null);
        ((ImageView) layer1.findViewById(R.id.layerImage)).setImageResource(R.drawable.bg);
        layer2 = inflater.inflate(R.layout.layer, null);
        ((ImageView) layer2.findViewById(R.id.layerImage)).setImageResource(R.drawable.water);
        layer3 = inflater.inflate(R.layout.layer, null);
        ((ImageView) layer3.findViewById(R.id.layerImage)).setImageResource(R.drawable.android);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
//        mImageView.setLayoutParams(layoutParams);
//        mImageView.setOnTouchListener(this);


        final int windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        final int windowheight = getWindowManager().getDefaultDisplay().getHeight();


        mainLayer.setOnTouchListener(new OnSwipeTouchListener(this) {
            View next=null,current=null, previous=null;
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
//                mImageView.setVisibility(View.GONE);
//                mImageView = (ImageView) findViewById(R.id.imageView);
                if(next == null && current== null && previous==null) {
                    mainLayer.addView(layer1);
                    layer1.startAnimation(slideInRight);
//                    mainLayer.startT
                    next = layer2;
                    current = layer1;
                } else if(current == layer1) {
                    mainLayer.addView(layer2);
                    layer2.startAnimation(slideInRight);
                    next = layer3;
                    current = layer2;
                    previous = layer1;
                } else if(current == layer2) {
                    mainLayer.addView(layer3);
                    layer3.startAnimation(slideInRight);
                    next = null;
                    current = layer3;
                    previous = layer2;
                }
                // if(next !=null) then current = next
            }

            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
//                mImageView = (ImageView) findViewById(R.id.imageView2);
//                mImageView.setVisibility(View.VISIBLE);

                if(previous != null) {
                    current.startAnimation(slideOutLeft);
                    mainLayer.removeView(current);
                    next = current;
                    current = previous;
                    if(current == layer3)
                        previous = layer2;
                    else if(current == layer2)
                        previous =layer1;
                    else
                        previous =null;
                } else
                    Toast.makeText(MainActivity.this, "No more views", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
