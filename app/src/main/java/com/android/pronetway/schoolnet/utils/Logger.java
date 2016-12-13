package com.android.pronetway.schoolnet.utils;

import android.util.Log;

/**
 * ***********************************************************
 * name: Log的工具类
 * overview:
 * usage:
 * 通过开关，控制是否打印log日志信息
 * 1，如果是测试模式，isDebug改为true, 打印日志信息
 * 2，如果是上线模式，isDebug改为false,不打印日志信息
 * *************************************************************
 */
public class Logger {
    //是否是测试模式
    private static boolean isDebug = true;

    private static final String TAG = "heheda";

    /**
     * 通过该方法打印Log.i类型的Log信息
     * @param str 需要Log输出的数据
     */
    public static void i(String str) {
        if (isDebug) {
            Log.i(TAG, str);
        }
    }
    /**
     * 通过该方法打印Log.e类型的Log信息
     * @param str 需要Log输出的数据
     */
    public static void e(String str) {
        if (isDebug) {
            Log.e(TAG, str);
        }
    }
    /**
     * 通过该方法打印Log.w类型的Log信息
     * @param str 需要Log输出的数据
     */
    public static void w(String str) {
        if (isDebug) {
            Log.w(TAG, str);
        }
    }
}
