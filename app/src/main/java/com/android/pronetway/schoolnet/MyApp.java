package com.android.pronetway.schoolnet;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.pronetway.schoolnet.Base.MyApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

import okhttp3.OkHttpClient;

/**
 * Created by Coleman on 2016/12/6.
 */
public class MyApp extends  Application {

    public static Context mContext;
    //SDCard图片缓存的文件夹夹的名字
    //是否是第一登录
    private static final String shref_filename = "config";
    //ctrl+shift+u
    private static final String IS_FISTLOGIN = "isfirstlogin";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Stetho.initializeWithDefaults(this);//网页查看调试
        Fresco.initialize(this);//图片
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        NoHttp.initialize(this, new NoHttp.Config()
                .setConnectTimeout(30 * 1000) // 全局连接超时时间，单位毫秒。
                .setReadTimeout(30 * 1000) // 全局服务器响应超时时间，单位毫秒。
                .setNetworkExecutor(new OkHttpNetworkExecutor())  // 使用OkHttp做网络层。
        );
        Logger.setDebug(true); // 开启NoHttp调试模式。
        Logger.setTag("NoHttpSample"); // 设置NoHttp打印Log的TAG。
    }
    public static boolean isFisrtLogin(){

        SharedPreferences shref = mContext.getSharedPreferences(shref_filename, Context.MODE_PRIVATE);
        boolean isFirst = shref.getBoolean(IS_FISTLOGIN , true);
        if (isFirst){
            shref.edit().putBoolean(IS_FISTLOGIN,false).apply();
        }
        return isFirst;
    }
}
