package com.example.tomze.multilevelselect;

import android.app.Application;

/**
 * Created by Administrator on 2018/10/24.
 * <p>
 * Description:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }
}
