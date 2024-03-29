package com.jacky.nohttp;


import android.content.Context;


/**
 * Created by 袁慎彬 on 2016/4/15.
 */
public class IRequest {
    /**
     * post请求
     */
    public static<T> PostRequest post(Context context, String url, T params) {
        return new <T>PostRequest(context, url, params);
    }

    /**
     * get请求
     */
    public static GetRequest get(Context context, String url) {
        return new GetRequest(context, url);
    }

    /**
     * 下载请求
     */
    public static  DownloadRequest download(Context context, String url) {
        return new DownloadRequest(context, url);
    }

    /**
     * 上传请求
     */
    public static <T> UploadRequest upload(Context context, String url, T params) {
        return new <T>UploadRequest(context, url, params);
    }
}
