package com.android.pronetway.schoolnet.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Coleman on 2016/12/7.
 */
public abstract class BaseTestFragmet extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflater.inflate()
        return loadXml(inflater);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        initView(view);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        initData();
    }

    /**
     * 加载布局，用于加载布局文件
     */
    protected abstract View loadXml(LayoutInflater inflater);

    /**
     * 初始化控件
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 设置数据
     */
    protected abstract void initData();



}
