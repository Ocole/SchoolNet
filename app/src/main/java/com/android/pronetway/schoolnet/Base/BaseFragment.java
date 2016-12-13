package com.android.pronetway.schoolnet.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hasee on 2016/2/20.
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflater.inflate()
        return loadXml(inflater);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

    public interface CallBack {
        void getData(Object o);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CallBack b = (CallBack) mActivity;
    }

    protected abstract void gg(CallBack c);
}
