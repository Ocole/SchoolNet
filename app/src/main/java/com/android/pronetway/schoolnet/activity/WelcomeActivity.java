package com.android.pronetway.schoolnet.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;
import android.widget.ImageView;

import com.android.pronetway.schoolnet.MainActivity;
import com.android.pronetway.schoolnet.MyApp;
import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.adapter.WelcomeAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一次登录产生的引导页面
 * ViewPager的侧滑实现
 */
public class WelcomeActivity extends AppCompatActivity {
    private ViewPager welcomePager;
    private CirclePageIndicator indicator;
    private List<ImageView> mList;
    private WelcomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        welcomePager = (ViewPager) findViewById(R.id.welcome_pager);
        indicator = (CirclePageIndicator) findViewById(R.id.cycle_indicator);

        //初始化数据源
        mList = new ArrayList<ImageView>();
        ImageView iv1 = (ImageView) getLayoutInflater().inflate(R.layout.image, null);
        iv1.setImageResource(R.drawable.img_frame_background);
        iv1.setImageResource(R.drawable.img_frame_background);
        mList.add(iv1);
        mList.add(iv1);
        mAdapter = new WelcomeAdapter(mList);
        welcomePager.setAdapter(mAdapter);
        //指示等的效果
        indicator.setViewPager(welcomePager);
        //监听(不需要写ViewPager)
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //切换到最后一页,点击按钮就可以跳转界面(可以动态添加,或者布局文件原来就存在动态显示)
                if (position == mList.size()-1) {
                    Intent intent = new Intent();
                    intent.setClass(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
