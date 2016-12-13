package com.android.pronetway.schoolnet.bean;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Coleman on 2016/12/6.
 */
public class GlideImageLoader extends ImageLoader {

    @Override
    public  void displayImage(Context context, Object path, ImageView imageView) {
        //用fresco加载图片简单用法
        Uri uri = Uri.parse((String) path);
        imageView.setImageURI(uri);

    }
    //提供createImageView 方法，如果不用可以不重写这个方法，方便fresco自定义ImageView
    @Override
    public ImageView createImageView(Context context) {
        SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
        return simpleDraweeView;
    }
}
