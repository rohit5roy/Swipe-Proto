package com.example.rohit.swipeprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        final ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        // Lookup view for data population
        final Animation slideInRight = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_right);
        slideInRight.setDuration(Long.valueOf("500"));
        final Animation slideInLeft = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_left);
        slideInLeft.setDuration(Long.valueOf("1000"));
        Animation slideOutLeft = AnimationUtils.loadAnimation(context, R.anim.slide_out_from_left);
        holder.view = convertView.findViewById(R.id.card);
        holder.text = (TextView) convertView.findViewById(R.id.post_title);
        holder.image = (ImageView) convertView.findViewById(R.id.imageView);
        holder.chat = (Button) convertView.findViewById(R.id.chat);
        holder.comment = (Button) convertView.findViewById(R.id.comment);
        holder.timing = (TextView) convertView.findViewById(R.id.timing);
        // Populate the data into the template view using the data object
        holder.text.setText(getItem(position));
        holder.chat.setText(String.valueOf("Chat:" + getItem(position)));
        holder.comment.setText(String.valueOf("Comments:"+ getItem(position)));

        if(Integer.valueOf(item)%2 == 0) {
            holder.image.setImageResource(R.drawable.ic_launcher);
            holder.timing.setText("Even");
            holder.view.startAnimation(slideInRight);
        }
        else {
//            holder.image.setImageResource(R.drawable.ic_launcher);
            holder.image.setImageResource(R.drawable.koove_text_logo);
            holder.timing.setText("Odd");
            holder.view.startAnimation(slideInRight);
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
//                holder.view.startAnimation(slideInLeft);
                ((AdapterViewAnimator)parent).showPrevious();
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
        convertView.setTag(holder);
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

    static class ViewHolder {
        View view;
        TextView text;
        ImageView image;
        Button chat;
        Button comment;
        TextView timing;
    }
}
