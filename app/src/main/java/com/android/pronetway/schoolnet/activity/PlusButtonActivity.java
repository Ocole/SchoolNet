package com.android.pronetway.schoolnet.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.pronetway.schoolnet.R;

public class PlusButtonActivity extends Activity implements View.OnClickListener {

    private LinearLayout layout;
    private LinearLayout ll_paybtn;
    private LinearLayout ll_newsbtn;
    private LinearLayout ll_express;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_button);
        initView();
        initListener();
    }

    private void initListener() {
        //添加选择窗口范围监听可以优先获取触点，即不再执行onTouchEvent()函数，点击其他地方时执行onTouchEvent()函数销毁Activity
        layout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭窗口！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //添加按钮监听
        ll_paybtn.setOnClickListener(this);
        ll_newsbtn.setOnClickListener(this);
        ll_express.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    private void initView() {
        ll_paybtn = ((LinearLayout) findViewById(R.id.ll_pay_main_plus_button));
        ll_newsbtn = ((LinearLayout) findViewById(R.id.ll_hotnews_main_plus_button));
        ll_express = ((LinearLayout) findViewById(R.id.ll_express_main_plus_button));
        layout = ((LinearLayout) findViewById(R.id.pop_layout));
        cancel = ((Button) findViewById(R.id.cancel_plus_button));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ll_pay_main_plus_button:

                break;
            case R.id.ll_hotnews_main_plus_button:

                break;
            case R.id.ll_express_main_plus_button:

                break;
            case R.id.cancel_plus_button:
                break;
            default:
                break;
        }
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
