package com.jacky.nohttp;

import android.content.Context;

import com.yolanda.nohttp.RequestMethod;

import util.JsonUtils;

public class PostRequest extends BaseRequest<PostRequest> {


    public <T> PostRequest(Context context, String url, T params) {
        this.url = url;
        this.context = context;
        this.params = JsonUtils.string(params);
    }

    public <T> void execute(Class<T> classOfT, RequestJsonListener<T> l) {
        RequestManager.loadArray(context, RequestMethod.POST, params, url, classOfT, isLoading, loadingTitle, timeOut, retry, l);
    }

    public  void execute(RequestListener l) {
        RequestManager.loadString(context, RequestMethod.POST, params,url, isLoading, loadingTitle, timeOut, retry, l);
    }
}
