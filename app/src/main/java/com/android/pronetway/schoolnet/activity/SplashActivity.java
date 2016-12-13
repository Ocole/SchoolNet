package com.android.pronetway.schoolnet.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pronetway.schoolnet.MainActivity;
import com.android.pronetway.schoolnet.MyApp;
import com.android.pronetway.schoolnet.R;
import com.squareup.picasso.Picasso;


/**
 * 广告,数秒以后会跳转到主界面
 * ImageView+Handler结合
 */
public class SplashActivity extends AppCompatActivity {
    private ImageView imageView;
    private static final int MSG_TURN = 0x00;
    private int duration = 1000;
    //倒计时3
    private int count = 5;
    private TextView countMiunsTest;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_TURN) {
                count--;
                countMiunsTest.setText(count + "秒,点击跳过");
                if (count <= 0) { //跳转界面
                    if (handler.hasMessages(MSG_TURN))
                        handler.removeMessages(MSG_TURN);
                    Intent intent = new Intent();
                    if (MyApp.isFisrtLogin()) {//第一次登陆的判断
                        intent.setClass(SplashActivity.this, WelcomeActivity.class);
                    } else {
                        intent.setClass(SplashActivity.this, MainActivity.class);
                    }
//                    intent.setClass(SplashActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {  //>0的时候才发
                    handler.sendEmptyMessageDelayed(MSG_TURN, duration);
                }
            }
        }
    };
    private String url = "http://www.17pr.com/attachment/cms/article/ueditor/images/20160114/1452750039578841.jpg"  ;

    /**
     * 点击倒计时文字的监听
     * count = 0, 发送消息,一样的效果
     */
    public void countTextClick(View v) {
        //直接跳转消息移除
        if (handler.hasMessages(MSG_TURN))
            handler.removeMessages(MSG_TURN);
        Intent intent = new Intent();
        if (MyApp.isFisrtLogin()) {//第一次登陆的判断
            intent.setClass(SplashActivity.this, WelcomeActivity.class);
        } else {
            intent.setClass(SplashActivity.this, MainActivity.class);
        }
//        intent.setClass(SplashActivity.this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        imageView = (ImageView) findViewById(R.id.splash_img);
        countMiunsTest = (TextView) findViewById(R.id.count_minus_text);

//        imageView.setImageResource(R.drawable.adbackgroud);
        Picasso.with(this).load(url).into(imageView); //fit,size都不适用,就是用自己的规则
        countMiunsTest.setText(count + "秒,广告点击跳过");
        //延时发送消息
        handler.sendEmptyMessage(MSG_TURN);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
