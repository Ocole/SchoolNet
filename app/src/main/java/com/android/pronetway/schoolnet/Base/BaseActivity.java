package com.android.pronetway.schoolnet.Base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadXml();
        initView();
        setListener();
        initData();
    }

    /**
     * 该方法用于加载布局
     * setContent等
     */
    protected abstract void loadXml();

    /**
     * 初始化控件
     * findById()等
     */
    protected abstract void initView();

    /**
     * 设置数据
     */
    protected abstract void initData();
    /**
     * 设置监听器
     * 所有的事件监听都写在该方法之中
     */
    protected abstract void setListener();

    /**
     * 短时间的Toast
     * @param str
     */
    protected void shortToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间的Toast
     * @param str
     */
    protected void longToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }





}
