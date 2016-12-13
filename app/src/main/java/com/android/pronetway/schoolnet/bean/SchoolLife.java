package com.android.pronetway.schoolnet.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Coleman on 2016/12/12.
 *
 * http://192.168.20.154:8006/pronline/Msg?FunName@ict_school_indexNews&page=1&dir=1&start=1&type=3&limit=10
 * type=3
 */
public class SchoolLife   implements Serializable {


    /**
     * result : 0
     * totalCount : 6
     * eimdata : [{"id":"23","title":"报到流程","picpath":"/uploadNews/147200688100150402.png","org":"【新网程】","content":"","view":"","type":"3","timeval":"2016-08-29 10:02:22"},{"id":"21","title":"花椒校历","picpath":"/uploadNews/147200543600210402.png","org":"【华东交大】","content":"","view":"","type":"3","timeval":"2016-08-29 10:01:44"},{"id":"24","title":"军训妙招","picpath":"/uploadNews/147200654700966103.png","org":"【新网程】","content":"","view":"","type":"3","timeval":"2016-08-25 16:22:05"},{"id":"27","title":"新生交流","picpath":"/uploadNews/147200691000492003.png","org":"【新网程】","content":"","view":"","type":"3","timeval":"2016-08-25 16:17:05"},{"id":"26","title":"疑惑解答","picpath":"/uploadNews/147200694600470004.png","org":"【新网程】","content":"","view":"","type":"3","timeval":"2016-08-25 10:24:21"}]
     */

    private String result;
    private String totalCount;
    /**
     * id : 23
     * title : 报到流程
     * picpath : /uploadNews/147200688100150402.png
     * org : 【新网程】
     * content :
     * view :
     * type : 3
     * timeval : 2016-08-29 10:02:22
     */

    private List<EimdataBean> eimdata;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<EimdataBean> getEimdata() {
        return eimdata;
    }

    public void setEimdata(List<EimdataBean> eimdata) {
        this.eimdata = eimdata;
    }

    public static class EimdataBean {
        private String id;
        private String title;
        private String picpath;
        private String org;
        private String content;
        private String view;
        private String type;
        private String timeval;

        public EimdataBean(String title, String picpath) {
            this.title = title;
            this.picpath = picpath;
        }

        public EimdataBean() {

        }


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
    }
}
