package com.android.pronetway.schoolnet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.pronetway.schoolnet.Base.BaseFragment;
import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.bean.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends BaseFragment {

    String position ;
    private List<String> titlesList;
    private List<String> imagesList;
    Banner banner;

    public static PayFragment getInstance(String position) {
        PayFragment mainFragment = new PayFragment();
        mainFragment.position = position;
        return mainFragment;
    }

    public PayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  loadXml(inflater);
    }

    @Override
    protected View loadXml(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_pay, null);
        return view;
    }

    @Override
    protected void initView(View view) {
//        banner = (Banner) view.findViewById(R.id.banner_pay);
    }

    @Override
    protected void initData() {
//        imagesList = getNetAdImages("images");
//        titlesList = getNetAdImagesTitles("titles");
//        initBannerImag();
    }

    @Override
    protected void gg(CallBack c) {

    }

    private List<String> getNetAdImages(String url) {
        imagesList = new ArrayList<>();
        imagesList.add("https://onegoods.nosdn.127.net/resupload/2016/11/21/086c6f9fd7038593d7cb53b470462ac1.jpg");
        imagesList.add("https://res.126.net/p/dbqb/resupload/onlinepath/2016/7/28/0/69e1275c4460f97f2d4b26d716348892.jpg");
        return imagesList;
    }

    private List<String> getNetAdImagesTitles(String url) {
        titlesList = new ArrayList<>();
        titlesList.add("11111111111111");
        titlesList.add("22222222222222");
        return titlesList;
    }

    private void initBannerImag() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
//        banner.setImages(imagesList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titlesList);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
