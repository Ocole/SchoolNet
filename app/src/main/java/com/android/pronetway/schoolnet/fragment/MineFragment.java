package com.android.pronetway.schoolnet.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.android.pronetway.schoolnet.Base.BaseFragment;
import com.android.pronetway.schoolnet.R;

/**
 * Created by Coleman on 2016/12/7.
 */
public class MineFragment extends BaseFragment {
    private String position;

    public static MineFragment getInstance(String position) {
        MineFragment hotPayFragment = new MineFragment();
        hotPayFragment.position = position;
        return hotPayFragment;
    }
    @Override
    protected View loadXml(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
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
