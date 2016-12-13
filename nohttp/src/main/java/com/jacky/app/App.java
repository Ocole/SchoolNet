package com.jacky.app;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by 袁慎彬 on 2016/7/11.
 */
public class App extends Application {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        NoHttp.initialize(this);
        Logger.setDebug(true);
    }


    public static Application getInstance() {
        return instance;
    }
}
