package com.koove;

import android.app.Application;
import android.content.res.Configuration;


//import com.facebook.stetho.Stetho;

/**
 * Created by myparichay on 5/5/15.
 */


public class KooveApplication extends Application {

//    public static GoogleAnalytics analytics;
//    public static Tracker tracker;

    /*
CLIENT SECRET
f81aba7c-1001-4723-a36b-3ae786e10254
CLIENT ID (DEVELOPMENT MODE)*
149718a00eda462295002f5503cdc090
 */

//    private static final String CREATIVE_SDK_SAMPLE_CLIENT_ID = "149718a00eda462295002f5503cdc090";
//    private static final String CREATIVE_SDK_SAMPLE_CLIENT_SECRET = "f81aba7c-1001-4723-a36b-3ae786e10254";

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate()
    {

        super.onCreate();

     //   Fabric.with(this, new Crashlytics());

       /* if(BuildConfig.DEBUG){
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build());
        }*/

    }

}
