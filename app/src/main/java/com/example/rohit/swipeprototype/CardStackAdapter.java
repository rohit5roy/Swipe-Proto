package com.example.rohit.swipeprototype;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Rohit on 07/10/15.
 */
public class CardStackAdapter extends ArrayAdapter<String> {

    private Context context;
    private int resourceId;
    private List<String> products;
    public CardStackAdapter(Context context, int resource, List<String> products) {
        super(context, resource, products);
        this.context = context;
        this.resourceId = resource;
        this.products = products;
    }

    @Override
    public View getView( final int position, View convertView, final ViewGroup parent) {
    // Get the data item for this position
        final String item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final View tmpView = convertView;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layer, parent, false);
        }

        // Lookup view for data population
        Animation slideInRight = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_right);
        final Animation slideInLeft = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_left);
        Animation slideOutLeft = AnimationUtils.loadAnimation(context, R.anim.slide_out_from_left);
        final TextView tv = (TextView) convertView.findViewById(R.id.textView);
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.layerImage);
        // Populate the data into the template view using the data object
        tv.setText(getItem(position));

        if(Integer.valueOf(item)%2 == 0) {
            imageView.setImageResource(R.drawable.bg);
            imageView.startAnimation(slideInLeft);
        }
        else {
            imageView.setImageResource(R.drawable.water);
            imageView.startAnimation(slideInLeft);
        }

        convertView.setOnTouchListener(new OnSwipeTouchListener(context) {
            int pos = position;
            @Override
            public void onSwipeLeft() {
                ((AdapterViewAnimator)parent).showNext();
                
//                if(position +1 < products.size()) {
////                    getView(++pos, tmpView, parent);
//                    tv.setText(getItem(position+1));
//                    if(Integer.valueOf(getItem(position+1))%2 == 0) {
//                        imageView.setImageResource(R.drawable.bg);
//                        imageView.startAnimation(slideInLeft);
//                    }
//                    else {
//                        imageView.setImageResource(R.drawable.water);
//                        imageView.startAnimation(slideInLeft);
//                    }
//                    // Return the completed view to render on screen
//
//                }
//                else
//                    Log.e("CardStackAdapter", "Maximum size limit");
            }

            @Override
            public void onSwipeRight() {
                ((AdapterViewAnimator)parent).showNext();
//                if(position -1 >0) {
////                    getView(--pos, tmpView, parent);
//                    tv.setText(getItem(position-1));
//                    if(Integer.valueOf(getItem(position-1))%2 == 0) {
//                        imageView.setImageResource(R.drawable.bg);
//                        imageView.startAnimation(slideInLeft);
//                    }
//                    else {
//                        imageView.setImageResource(R.drawable.water);
//                        imageView.startAnimation(slideInLeft);
//                    }
//                }
//                else
//                    Log.e("CardStackAdapter", "Minimum size limit");
            }

            @Override
            public void onSwipeTop() {
                Toast.makeText(context, "Swiped towards Top", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public int getPosition(String item) {
        return super.getPosition(item);
    }

    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
