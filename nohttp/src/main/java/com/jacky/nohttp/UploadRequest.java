package com.jacky.nohttp;

import android.content.Context;

import com.yolanda.nohttp.RequestMethod;

import util.JsonUtils;


/**
 * Created by 袁慎彬 on 2016/6/24.
 */
public class UploadRequest extends BaseRequest<UploadRequest> {
    public <T> UploadRequest(Context context, String url, T params) {
        this.url = url;
        this.context = context;
        this.params = JsonUtils.string(params);
    }

    public <T> void execute(Class<T> classOfT, RequestJsonListener<T> l) {
        RequestManager.loadArray(context, RequestMethod.POST, params, url, classOfT, isLoading, loadingTitle, timeOut, retry, l);
    }

    public void execute(RequestListener l) {
        RequestManager.loadUploadString(context, params, url, uploadFiles, isLoading, loadingTitle, l);
    }
}