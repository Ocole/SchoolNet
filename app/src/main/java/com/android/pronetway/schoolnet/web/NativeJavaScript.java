package com.android.pronetway.schoolnet.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Coleman on 2016/12/13.
 */
public class NativeJavaScript {

    //属性
    private Context mContext;

    /**
     * 构造器
     * @param context
     */
    public NativeJavaScript(Context context){
        this.mContext = context;
    }

    /**
     * 显示toast
     */
    @JavascriptInterface
    public void showToast(){
        Toast.makeText(mContext,"JavaScript回调android本地方法",Toast.LENGTH_SHORT).show();
    }

    /**
     * 关闭当前的Activity
     */
    @JavascriptInterface//不能少，4.2及以后的都必须要加，否则没法访问该方法
    public void closeCurActivity(){
        ((Activity)mContext).finish();
    }

    /**
     * 跳转到下一个界面
     */
    @JavascriptInterface
    public void startNextActivity(){
        mContext.startActivity(new Intent(mContext,NextActivity.class));
    }
}
