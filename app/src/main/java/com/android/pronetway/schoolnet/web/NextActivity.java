package com.android.pronetway.schoolnet.web;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Coleman on 2016/12/13.
 */
public class NextActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("当前界面是有html界面跳转过来的");
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40);
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 40);
        ll.setMargins(0,50,0,0);
        tv.setLayoutParams(ll);
        setContentView(tv);
    }

}
