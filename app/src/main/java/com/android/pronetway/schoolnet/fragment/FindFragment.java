package com.android.pronetway.schoolnet.fragment;


import android.app.Service;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.pronetway.schoolnet.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {
    private PopupWindow popupWindowHeader;
    //屏幕的宽度
    private int screenWidth;
    //定义数据源
    private List<LinearLayout> mLists;
    //模拟获取到json的数据源
    private String[] data = new String[]{
            "http://bzpic.spriteapp.cn/picture1/M00/12/B0/wKiFQ1ULzuOAMR0wAADGL6xKvsU460.jpg",
            "http://bzpic.spriteapp.cn/picture1/M00/11/F9/wKiFR1TcSciAKV0zAACc36zjkk4420.jpg",
            "http://bzpic.spriteapp.cn/picture2/M00/0C/CA/wKiFWVSiYXCAILoUAAEBLSGURNI161.jpg",
            "http://bzpic.spriteapp.cn/picture1/M00/11/10/wKiFQ1SjsOyAXY1XAADpIk50-c8273.jpg",
            "http://bzpic.spriteapp.cn/picture1/M00/10/EC/wKiFR1SaSsaAEnoOAAEab91CYJg761.jpg",
            "http://bzpic.spriteapp.cn/picture1/M00/0D/E7/wKiFQ1OC8UOAb_OqAAIQlio7-nE056.jpg",
    };
    //因为一页放2张图
    private int showImageCount = 2;
    private String position;


    public static FindFragment getInstance(String position) {
        FindFragment searchFragment  = new FindFragment();
        searchFragment.position = position;
        return searchFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        mLists = new ArrayList<LinearLayout>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //实例对象
        popupWindowHeader = new PopupWindow(getActivity());
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final LinearLayout hearder = (LinearLayout) view.findViewById(R.id.search_header);
        hearder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出popupwindow
                showHeaderPopup(hearder);
            }
        });


        //ViewPager的够写
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        //模拟源完毕了
        initViewPagerData();
        //自己Adapter中定义
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return  mLists.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                LinearLayout linearLayout = mLists.get(position);
                container.addView(linearLayout);
                return linearLayout;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }

    /**
     * 模拟ViewPager的数据源
     */
    public void initViewPagerData() {
        for (int i = 0; i < data.length / showImageCount; i++) {
            //动态构建LinearLayout
            LinearLayout llayout = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.linearlayout, null);
            //动态加入ImageView
            for (int j = 0; j < showImageCount; j++) {
                ImageView imageView = new ImageView(getActivity());
                //动态设置weight
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                //动态修改layout_width和layout_height,layout_weight,layout_margin都要在LayoutParam进行设置
                //设置xml中和layout开头有关的属性
                lp.width = 0; //是0
                lp.height = 126;
                lp.weight = 1;
                lp.leftMargin = 10;
                lp.topMargin =10;
                lp.bottomMargin = 10;
                lp.rightMargin = 10;
                imageView.setLayoutParams(lp); //设置lp参数就会生效了,分块的写法,因为设置的参数不只是宽度高度了
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //图片源
                /**
                 *  index: 0 (i= 0 ,j=0)
                 *  index: 1 (i= 0 ,j=1)
                 *  index: 2 (i= 1 ,j=0)
                 *  index: 3 (i= 1 ,j=1)
                 *  index: 4 (i= 2 ,j=0)
                 *  index: 5 (i= 2 ,j=1)
                 *
                 */
                String url = data[i * showImageCount + j];
                Log.i("123","index"+(i * showImageCount + j));
                Log.i("123","url-->"+url);
                //Picasso加载
                Picasso.with(getActivity()).load(url).into(imageView); //fit,size都不适用,就是用自己的规则
                //添加到容器中
                llayout.addView(imageView);
            }
            //将每个LinearLayout添加到容器中
            mLists.add(llayout);
        }
        //Log.i("123","mList-->"+mLists);
    }


    public void showHeaderPopup(LinearLayout hearder) {
        //唯一的一个,没有显示视图的进行视图的显示
        if (!popupWindowHeader.isShowing()) {
            //1.设置popupwindow的宽度和高度
            popupWindowHeader.setWidth(screenWidth);
            //以当前hearder的高度参考
            popupWindowHeader.setHeight(hearder.getMeasuredHeight() + 33);
            //2.自定义布局
            View view = getActivity().getLayoutInflater().inflate(R.layout.popup_searchview, null);
            EditText editText = (EditText) view.findViewById(R.id.et);
            editText.setFocusable(true);
            editText.requestFocus();   //像系统请求焦点
            TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { //点击取消关闭弹出框
                    popupWindowHeader.dismiss();
                }
            });
            popupWindowHeader.setContentView(view);
            //其他参数
            popupWindowHeader.setOutsideTouchable(true);
            //没有获取焦点的话,里面的EditText无法输入
            popupWindowHeader.setFocusable(true);
            //3.显示的位置(y便宜状态栏的高度)
            popupWindowHeader.showAtLocation(hearder, Gravity.TOP, 0, 30);
            //调用输入法显示的方法
            //系统提供的输入法服务
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Service.INPUT_METHOD_SERVICE);
            //调用实现的方法就可以了 (按照参数说明的要求显示就可以了)
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
            //输入法顶替了原来的问题,清单文件设置输入放对话弹出的固定位置
        }
    }
}
