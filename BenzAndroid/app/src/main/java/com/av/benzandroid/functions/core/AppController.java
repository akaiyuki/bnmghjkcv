package com.av.benzandroid.functions.core;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.av.benzandroid.BuildConfig;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by CodeSyaona on 9/5/16.
 */
public class AppController extends Application {

    private static AppController mInstance;

    public static synchronized AppController getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        if (!BuildConfig.DEBUG){
            Fabric.with(this, new Crashlytics());
        }


    }




}
