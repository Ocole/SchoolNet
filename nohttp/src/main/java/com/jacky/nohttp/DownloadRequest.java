package com.jacky.nohttp;

import android.content.Context;

import com.yolanda.nohttp.download.DownloadListener;


/**
 * Created by 袁慎彬 on 2016/6/22.
 */
public class DownloadRequest extends BaseRequest<DownloadRequest> {
    public DownloadRequest(Context context, String url) {
        this.url = url;
        this.context = context;
    }

    public void execute(DownloadListener l) {
        RequestManager.loadDownload(context, url, what, fileFolder, fileName, isRange, isDeleteOld, l);
    }
}
