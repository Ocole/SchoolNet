package com.android.pronetway.schoolnet.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class FragmentHomeMsgAdapter extends PagerAdapter {
    private List<View>  mImags;

    public FragmentHomeMsgAdapter(List<View>  data){
        mImags = data;
    }
    @Override
    public int getCount() {
        return mImags.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View img = mImags.get(position);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
