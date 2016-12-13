package com.android.pronetway.schoolnet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.pronetway.schoolnet.MainActivity;
import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.bean.Eimdata;
import com.android.pronetway.schoolnet.bean.P;
import com.android.pronetway.schoolnet.bean.SchoolLife;
import com.android.pronetway.schoolnet.web.NativeJavaScript;
import com.loopj.android.http.LogInterface;
import com.thefinestartist.finestwebview.FinestWebView;
import com.thefinestartist.finestwebview.listeners.WebViewListener;

import java.util.List;

public class DetailNewsActivity extends Activity {

    private WebView mVebView;

    List<String> urlList   ;

    String url = "http://news.china.com/domesticgd/10000159/20161211/30074337.html";
//    String urldetail = "http://192.168.20.154:8006/wap/newsDetails.html?id=8";
    String urldetail = P.HTTP+P.IP+P.PORT+P.GET_NEWS_DETAIL ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        initData();
//        initView();
        return super.onCreateView(parent, name, context, attrs);

    }

    private void initData() {
        FinestWebView.Builder build = new FinestWebView.Builder(this);
        SchoolLife.EimdataBean schools = (SchoolLife.EimdataBean) getIntent().getSerializableExtra("school");
        Eimdata news = (Eimdata) getIntent().getSerializableExtra("news");
        Log.i("cole", "initData: Eimdata 是不是为空："+  (news == null? true : news.toString())  );
        if (news != null) {
            build.titleDefault(news.getTitle())
                    .toolbarScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS)
                    .gradientDivider(true)
                    .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                    .stringResRefresh(R.string.refresh)
                    .stringResShareVia(R.string.share_via)
                    .stringResCopyLink(R.string.copy_link)
                    .stringResOpenWith(R.string.open_with)
                    .iconDisabledColorRes(R.color.gray)
                    .iconPressedColorRes(R.color.black)
                    .backPressToClose(true)
                    .showIconClose(true)
                    .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
                    .show(urldetail+news.getId());
        }
        if (schools != null) {
            build.titleDefault(schools.getTitle())
                    .toolbarScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS)
                    .gradientDivider(true)
                    .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                    .stringResRefresh(R.string.refresh)
                    .stringResShareVia(R.string.share_via)
                    .stringResCopyLink(R.string.copy_link)
                    .stringResOpenWith(R.string.open_with)
                    .iconDisabledColorRes(R.color.gray)
                    .iconPressedColorRes(R.color.black)
                    .backPressToClose(true)
                    .showIconClose(true)
                    .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
                    .show(urldetail+schools.getId());
        }
    }

    private void initView() {
        mVebView = ((WebView) findViewById(R.id.wv_detail_news));
        mVebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings webSettings = mVebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mVebView.addJavascriptInterface(new NativeJavaScript(this),"NativeJavaScript");
        //file:///android_asset/
        mVebView.loadUrl("file:///android_asset/web/index.html");
//        mVebView.loadUrl(url);


//        new FinestWebView.Builder(this).show(url);

//        FinestWebView.Builder build = new FinestWebView.Builder(this);
//        FinestWebView web = new FinestWebView();
//
//        build
//                .titleDefault("校园咨询")
//                .toolbarScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS)
//                .gradientDivider(true)
//
//                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
//                .stringResRefresh(R.string.refresh)
//                .stringResShareVia(R.string.share_via)
//                .stringResCopyLink(R.string.copy_link)
//                .stringResOpenWith(R.string.open_with)
//                .iconDisabledColorRes(R.color.gray)
//                .iconPressedColorRes(R.color.black)
//
//                .backPressToClose(true)
//
//                .showIconClose(true)
//
//                .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
//                .show(url);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
