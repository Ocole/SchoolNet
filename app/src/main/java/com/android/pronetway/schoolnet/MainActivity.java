package com.android.pronetway.schoolnet;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.pronetway.schoolnet.Base.PublicWay;
import com.android.pronetway.schoolnet.activity.PlusButtonActivity;
import com.android.pronetway.schoolnet.fragment.HomeFragment;
import com.android.pronetway.schoolnet.fragment.MineFragment;
import com.android.pronetway.schoolnet.fragment.PayFragment;
import com.android.pronetway.schoolnet.fragment.SearchFragment;
import com.android.pronetway.schoolnet.view.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String[] mTitles = {"首页", "发现", "","充值", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.tabbar_home,
            R.drawable.tabbar_discover,
            R.drawable.tabbar_compose_icon_add,
            R.drawable.toolbar_compose,
            R.drawable.ic_tabbar_mine,
           };
    private int[] mIconSelectIds = {
            R.drawable.tabbar_home_selected,
            R.drawable.tabbar_discover_selected,
            R.drawable.tabbar_compose_icon_add,
            R.drawable.toolbar_compose_highlighted,
            R.drawable.tabbar_mine,
            };
    //tab的标题、选中图标、未选中图标
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private boolean isExit;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            isExit = false;
        }

    };
    private CommonTabLayout mTabLayout;
    private FrameLayout framLayout;
    private RadioButton tab_main_find;
    private RadioButton tab_main_pay;
    private RadioButton tab_main_home;
    private RadioButton tab_main_mine;
    private ImageView iv_tab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        iv_tab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PlusButtonActivity.class));
            }
        });
    }

    private void initTab() {
        tab_main_home = (RadioButton) findViewById(R.id.tab_main_home);
        tab_main_find = (RadioButton) findViewById(R.id.tab_main_find);
        tab_main_pay = (RadioButton) findViewById(R.id.tab_main_pay);
        tab_main_mine = (RadioButton) findViewById(R.id.tab_main_mine);
    }

    private void initView() {
        mTabLayout = (CommonTabLayout) findViewById(R.id.ctab_main);
        framLayout = (FrameLayout) findViewById(R.id.fl_main_change);
        iv_tab_add = (ImageView) findViewById(R.id.iv_tab_add);

    }

    private void initData() {
        for (String title : mTitles) {
            mFragments.add(HomeFragment.getInstance( title));
            mFragments.add(SearchFragment.getInstance( title));
            mFragments.add(PayFragment.getInstance( title));
            mFragments.add(MineFragment.getInstance( title));
        }
        Log.i("cole", "=+++++++++++++++- ");
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities, this, R.id.fl_main_change, mFragments);
    }



    /**
     * 返回两次退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void exit(){
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            for(int i = 0; i< PublicWay.activityList.size(); i++){
                if (null != PublicWay.activityList.get(i)) {
                    PublicWay.activityList.get(i).finish();
                }
            }
            System.exit(0);
        }
    }

    public static Animation createItemOutAnimation(Context context, int index, long expandDuration, int x, int y){

        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        long alphaDuration = 60;
        if(expandDuration < 60){
            alphaDuration = expandDuration / 4;
        }
        alphaAnimation.setDuration(alphaDuration);
        alphaAnimation.setStartOffset(0);

        //x和y是球弹到最高点的坐标
        TranslateAnimation translate = new TranslateAnimation(0, x, 0, y);

        translate.setStartOffset(0);
        translate.setDuration(expandDuration);
        //OvershootInterpolator：表示向前甩一定值后再回到原来位置。
//        translate.setInterpolator(context, R.anim.sat_item_overshoot_interpolator);

        RotateAnimation rotate = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        //AccelerateInterpolator：动画从开始到结束，变化率是一个加速的过程。
        //DecelerateInterpolator：动画从开始到结束，变化率是一个减速的过程
//        rotate.setInterpolator(context, R.anim.sat_item_out_rotate_interpolator);

        long duration = 100;
        if(expandDuration <= 150){
            duration = expandDuration / 3;
        }

        rotate.setDuration(expandDuration-duration);
        rotate.setStartOffset(duration);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(false);
        animationSet.setFillBefore(true);
        animationSet.setFillEnabled(true);

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotate);
        animationSet.addAnimation(translate);

        animationSet.setStartOffset(30*index);

        return animationSet;
    }
}
