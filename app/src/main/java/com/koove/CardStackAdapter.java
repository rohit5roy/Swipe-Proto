package com.koove;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohit.swipeprototype.R;

import java.util.ArrayList;

/**
 * Created by Rohit on 07/10/15.
 */
public class CardStackAdapter extends ArrayAdapter<String> {

    private Context context;
    private int resourceId;
    private ArrayList<String> products;
    public CardStackAdapter(Context context, int resource, ArrayList<String> products) {
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
        final ViewGroup tmpView = (ViewGroup) convertView;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layer, parent, false);
        }

        // Lookup view for data population
        final TextView tv = (TextView) convertView.findViewById(R.id.textView);
        tv.setText(getItem(position));


        return convertView;
    }

    @Override
    public int getPosition(String item) {
        return products.indexOf(item);
    }

    @Override
    public String getItem(int position) {
        return products.get(position);
    }

    @Override
    public int getCount() {
        return products.size();
    }
}
