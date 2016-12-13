package com.android.pronetway.schoolnet.Base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * ***********************************************************
 * name: 全局信息的类
 * overview: 程序一开始，最先执行的类； 一般在这里写全局信息，包括最初的初始化设置；
 * 例如：百度地图定位，ImageLoader初始化配置，Xutils初始化配置等等。
 * usage:
 * 1，写一个类 继承 Application类
 * 2，把这个类在 清单文件中的Application 节点下 做配置  。
 * 例如：   <application
 * android:name=".base.MyApplication">
 * *************************************************************
 */
public class MyApplication extends Application {

    private Context mContext;

    /**
     * 屏幕的宽
     */
    public static int displayWidth;
    /**
     * 屏幕的宽高
     */
    public static int displayHeight;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initDisplay();
    }

    /**
     * 初始化屏幕的宽高
     */
    private void initDisplay() {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        displayWidth = displayMetrics.widthPixels;
        displayHeight = displayMetrics.heightPixels;
    }
}
