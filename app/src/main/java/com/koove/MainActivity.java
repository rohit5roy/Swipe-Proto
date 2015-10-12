package com.koove;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.rohit.swipeprototype.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements CardContainer.GetMoreData {
//        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static final String TAG = "SwipeProto";
    private CardStackAdapter stackAdapter;
    private CardContainer cardContainer;

    FrameLayout mainLayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayer = (FrameLayout)findViewById(R.id.root);
        cardContainer = (CardContainer) findViewById(R.id.stack);
        new GetPosts().execute();
        String [] arr = {};;
        stackAdapter = new CardStackAdapter(MainActivity.this, R.layout.layer, new ArrayList<String>(Arrays.asList(arr)));

       // stackAdapter.addAll();


    }

    @Override
    public void getData() {
        String [] arr = {"1","2","3","4"};;
        stackAdapter = (CardStackAdapter) cardContainer.getAdapter();
        stackAdapter.addAll(new ArrayList<>(Arrays.asList(arr)));
        stackAdapter.notifyDataSetChanged();

    }



    private class GetPosts extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String [] arr = {"1","2","3","4", "5", "6", "7", "8", "9"};
                    stackAdapter.addAll(new ArrayList<>(Arrays.asList(arr)));
                    cardContainer.setAdapter(stackAdapter);
                   // stackAdapter.notifyDataSetChanged();
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

    }
}
