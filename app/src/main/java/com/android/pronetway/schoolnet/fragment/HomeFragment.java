package com.android.pronetway.schoolnet.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.android.pronetway.schoolnet.Base.BaseFragment;
import com.android.pronetway.schoolnet.MainActivity;
import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.activity.DetailNewsActivity;
import com.android.pronetway.schoolnet.bean.GlideImageLoader;
import com.android.pronetway.schoolnet.view.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    String position;
    String TAG = "cole_home";
    private List<String> titlesList;
    private List<String> imagesList;
    Banner banner;
    private ViewPager viewPagerBtn;
    CommonTabLayout tabMsg;
    private String[] mTitles = {"校园咨询", "校园地图", "上网套餐", "快递查询"};
    private String[] mNewsTitles = { "咨询热点","充值缴费", "热卖套餐"};
//    private String[] mTitles = {"校园咨询", "校园地图", "上网套餐", "快递查询","快递查询","快递查询"};

    private int[] mIconSelectIds = {
            R.drawable.school_msg,
            R.drawable.map,
            R.drawable.netpay,
            R.drawable.express,
//            R.drawable.express,
//            R.drawable.express,
    };
    private int[] mIconUnselectIds = {
            R.drawable.school_msg,
            R.drawable.map,
            R.drawable.netpay,
            R.drawable.express,
//            R.drawable.express,
//            R.drawable.express,
    };
    //tab的标题、选中图标、未选中图标
    private ArrayList<CustomTabEntity> mTabEntities;
    private ArrayList<CustomTabEntity> mTabNewsEntities;
    private Context mContext ;
    private CommonTabLayout tabNewsMsg;
    private FrameLayout framlayoutNews;
    private ArrayList<Fragment> mNewsFragmentsList = new ArrayList<>();
    private FragmentManager manager;
    private FragmentActivity fa;
    private FragmentTransaction tra;



    public static HomeFragment getInstance(String position) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.position = position;
        return homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        fa = getActivity();
        manager = fa.getSupportFragmentManager();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        banner = (Banner) view.findViewById(R.id.banner);
//        viewPagerBtn = (ViewPager) view.findViewById(R.id.vp_fragment_home_btn);
        tabMsg = (CommonTabLayout) view.findViewById(R.id.ctab_fragment_home);
        tabNewsMsg = (CommonTabLayout) view.findViewById(R.id.ctab_news_fragment_home);
        framlayoutNews = (FrameLayout) view.findViewById(R.id.fl_home_change);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void initData() {
        imagesList = getNetAdImages("images");
        titlesList = getNetAdImagesTitles("titles");
        initBannerImag();
        initTab();
//        initListener();

    }


    private void initTab() {
        mTabEntities = new ArrayList<>();
        mTabNewsEntities = new ArrayList<>();
        mNewsFragmentsList = new ArrayList<>();
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabMsg.setTabData(mTabEntities);
        tabMsg.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
//                    startActivity(new Intent(mContext, DetailNewsActivity.class));

                }
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    startActivity(new Intent(mContext, DetailNewsActivity.class));
                }
            }
        });
        //设置tab的 News
        for (int i = 0; i < mNewsTitles.length ; i++) {
            mTabNewsEntities.add(new TabEntity(mNewsTitles[i], 0, 0));
        }
        tabNewsMsg.setTabData(mTabNewsEntities);
        Log.i(TAG, "=home————————————- ");
        initNewsFragment();
        tabNewsMsg.setCurrentTab(0);
//        for (String title : mNewsTitles) {
//            mNewsFragmentsList.add(PayFragment.getInstance(title));
//            mNewsFragmentsList.add(HotPayFragment.getInstance(title));
//            mNewsFragmentsList.add(NewsFragment.getInstance(title));
//        }
//        tabNewsMsg.setTabData(mTabNewsEntities, (FragmentActivity) mContext,R.id.fl_home_change ,mNewsFragmentsList);

    }

    private void initNewsFragment() {
        mNewsFragmentsList.add(new NewsFragment());
        mNewsFragmentsList.add(new PayFragment());
        mNewsFragmentsList.add(new HotPayFragment());


        tabNewsMsg.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                addFragmentToStack(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


    }

    /**
     * fragment的hide()和show()方法
     * @param cur
     */
    private void addFragmentToStack(int cur){
        tra=manager.beginTransaction();
        Fragment fragment=mNewsFragmentsList.get(cur);
        if(!fragment.isAdded()){
            tra.add(R.id.fl_home_change,fragment);
//			tra.attach(fragment);
        }
        for (int i = 0; i < mNewsFragmentsList.size(); i++) {
            Fragment f=mNewsFragmentsList.get(i);
            if(i==cur&&f.isAdded()){
                tra.show(f);
            }else if(f!=null &&f.isAdded()&&f.isVisible()){
                tra.hide(f);
            }
        }
        tra.commitAllowingStateLoss();
    }



    private void initListener() {
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tabMsg.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        tabNewsMsg.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                for (int i = 0; i < mNewsFragmentsList.size()-1; i++) {
//                        showFragment(R.id.fl_home_change, position, mNewsFragmentsList.get(i));
                }

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private List<String> getNetAdImages(String url) {
        imagesList = new ArrayList<>();
        imagesList.add("https://onegoods.nosdn.127.net/resupload/2016/11/21/086c6f9fd7038593d7cb53b470462ac1.jpg");
        imagesList.add("https://res.126.net/p/dbqb/resupload/onlinepath/2016/7/28/0/69e1275c4460f97f2d4b26d716348892.jpg");
        return imagesList;
    }

    private List<String> getNetAdImagesTitles(String url) {
        titlesList = new ArrayList<>();
        titlesList.add("day day up to go");
        titlesList.add("never give up !");
        return titlesList;
    }

    private void initBannerImag() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imagesList);
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
