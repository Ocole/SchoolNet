package com.android.pronetway.schoolnet.bean;

/**
 * Created by Coleman on 2016/12/12.
 */
public class ADBean {

    private String id;
    private String title;
    private String picpath;
    private String org;
    private String content;
    private String view;
    private String type;
    private String timeval;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getTimeval() {
        return timeval;
    }

    public void setTimeval(String timeval) {
        this.timeval = timeval;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ADBean(String content, String id, String org, String picpath, String timeval, String title, String type, String view) {
        this.content = content;
        this.id = id;
        this.org = org;
        this.picpath = picpath;
        this.timeval = timeval;
        this.title = title;
        this.type = type;
        this.view = view;
    }
    public ADBean( String id,    String picpath,   String title  ) {

        this.id = id;

        this.picpath = picpath;

        this.title = title;


    }
    public ADBean(   ) {



    }
}
