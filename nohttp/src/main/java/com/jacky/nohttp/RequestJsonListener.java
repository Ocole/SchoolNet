package com.jacky.nohttp;

import com.yolanda.nohttp.rest.Response;

/**
 * 小袁
 * Created by Administrator on 2015/3/11.
 */
public abstract class RequestJsonListener<T> extends BaseRequestListener {
    /**
     * 成功
     */
    public abstract void onSuccess(Response<T> response);

}
