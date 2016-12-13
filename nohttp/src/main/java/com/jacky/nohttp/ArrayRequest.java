package com.jacky.nohttp;

import android.content.Context;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.RestRequest;
import com.yolanda.nohttp.rest.StringRequest;

import util.JsonUtils;

/**
 * Created by 袁慎彬 on 2016/6/21.
 */
public class ArrayRequest<T> extends RestRequest<T> {
    private Class<T> classOfT;
    private Context context;

    public ArrayRequest(String url) {
        super(url);
    }
    public ArrayRequest(Context context, String url, RequestMethod requestMethod, Class<T> classOfT) {
        super(url, requestMethod);
        this.classOfT = classOfT;
        this.context = context;
    }

    @Override
    public T parseResponse(String url, Headers responseHeaders, byte[] responseBody) {
        String result = StringRequest.parseResponseString(url, responseHeaders, responseBody);
        return JsonUtils.object(result, classOfT);
    }

    @Override
    public String getAccept() {
        return "application/json";
    }

}
