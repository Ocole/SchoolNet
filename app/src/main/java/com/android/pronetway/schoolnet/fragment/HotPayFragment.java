package com.android.pronetway.schoolnet.fragment;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.android.pronetway.schoolnet.Base.BaseFragment;
import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.adapter.MyNewsAdapter;
import com.android.pronetway.schoolnet.utils.CHttpUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Coleman on 2016/12/7.
 */
public class HotPayFragment extends BaseFragment {
    private String position;


    public static HotPayFragment getInstance(String position) {
        HotPayFragment hotPayFragment = new HotPayFragment();
        hotPayFragment.position = position;
        return hotPayFragment;
    }
    @Override
    protected View loadXml(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_hotpay, null);
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void gg(CallBack c) {

    }



}
