package com.android.pronetway.schoolnet.bean;

import java.io.Serializable;

/**
 * Created by Coleman on 2016/12/8.
 */
public class Eimdata extends BaseBean  implements Serializable {
    private String id;
    private String title;
    private String picpath;
    private String org;
    private String content;
    private String view;
    private String type;
    private String timeval;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeval() {
        return timeval;
    }

    public void setTimeval(String timeval) {
        this.timeval = timeval;
    }

    @Override
    public String toString() {
        return "EimdataBean{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", picpath='" + picpath + '\'' +
                ", org='" + org + '\'' +
                ", view='" + view + '\'' +
                ", type='" + type + '\'' +
                ", timeval='" + timeval + '\'' +
                '}';
    }
}

