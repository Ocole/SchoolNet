package com.android.pronetway.schoolnet.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Coleman on 2016/12/7.
 * url:newslist====http://192.168.20.154:8006/pronline/Msg?FunName@ict_school_indexNews&page=1&dir=1&start=1&type=&limit=10
 * url:detailmsg====http://192.168.20.154:8006/wap/newsDetails.html?id=
 * url:pic====http://192.168.20.154:8006/uploadNews/148098749800418748.png
 */
public class NewsBean  extends BaseBean implements Serializable {


    /**
     * result : 0
     * totalCount : 17
     * eimdata : [{"id":"40","title":"123","picpath":"/uploadNews/148098749800418748.png","org":"123","content":"","view":"123","type":"0","timeval":"2016-12-06 09:24:58"},{"id":"8","title":"华东交大学子曹硕闯入里约奥运男子三级跳远决赛","picpath":"/uploadNews/147303822800387939.png","org":"【凤凰网】","content":"","view":"","type":"0","timeval":"2016-11-24 17:39:02"},{"id":"17","title":"心理健康教育应用与学术接轨","picpath":"/uploadNews/147303848500113241.png","org":"【华东交大校报】","content":"","view":"8月19日，由中国心理学会出版工作委员会主办、心理素质教育研究院承办的\u201c《儒道佛与认知神经科学》撰写工作研讨会暨现代心理学与脑认知科学视","type":"0","timeval":"2016-11-24 17:38:57"},{"id":"15","title":"96届机制专业毕业20周年返校聚会","picpath":"/uploadNews/147303847500510240.png","org":"【华东交大机电学院】","content":"","view":"8月20日，机制专业96届毕业生返校举行毕业20周年座谈会。副校长史焕平、对外联络处处长兼校友工作办公室主任罗侃、机电与车辆工程学院院长刘燕德","type":"0","timeval":"2016-11-24 17:38:50"},{"id":"9","title":"体验长征路","picpath":"/uploadNews/147192685400942121.png","org":"【中国青年网】","content":"","view":"中国青年网南昌7月13日电（通讯员 肖晓红 杨佳煜）一瓶水，一包压缩饼干，背上一些简单的装备，一行来自黑龙江、内蒙古、新疆等21个省市自治区的","type":"0","timeval":"2016-11-24 17:38:22"},{"id":"20","title":"徐长节教授入选国家\u201c万人计划\u201d","picpath":"/uploadNews/147194045400661950.png","org":"【华东交大校报】","content":"","view":"经专家组评审并报中央领导同志同意，中共中央组织部办公厅于8月1日印发《关于第二批国家\u201c万人计划\u201d领军人才入选名单的通知》（组厅字〔2016〕3","type":"1","timeval":"2016-11-07 16:29:42"},{"id":"32","title":"心理素质教育研究","picpath":"/uploadNews/147349784000568311.jpeg","org":"【新闻来源】","content":"","view":"8月19日，由中国心理学会出版工作委员会主办、心理素质教育研究院承办的\u201c《儒道佛与认知神经科学》撰写工作研讨会暨现代心理学与脑认知科学视","type":"1","timeval":"2016-11-07 16:26:40"},{"id":"18","title":"万明慰问暑期坚守岗位的教职工","picpath":"/uploadNews/147194022100946843.png","org":"【华东交大校报】","content":"","view":"","type":"0","timeval":"2016-08-24 15:44:26"},{"id":"19","title":"汪立夏赴江苏多地开拓毕业生就业市场","picpath":"/uploadNews/147194037100316548.png","org":"【华东交大招就处】","content":"","view":"","type":"0","timeval":"2016-08-24 15:44:14"},{"id":"16","title":"我校与南昌轨道交通集团合作完成项目获鉴定专家肯定：总体达到国际先进水平","picpath":"/uploadNews/147194122000645612.png","org":"【华东交大土木学院】","content":"","view":"","type":"1","timeval":"2016-08-24 15:43:47"},{"id":"12","title":"华东交大：全国\u201c校长杯\u201d网球赛一举夺魁","picpath":"/uploadNews/147194124900983616.png","org":"【江西手机报】","content":"","view":"","type":"1","timeval":"2016-08-24 15:43:15"},{"id":"11","title":"华东交通大学学生荣获国际级运动健将称号","picpath":"/uploadNews/147194138300571121.png","org":"【江西教育网】","content":"","view":"","type":"1","timeval":"2016-08-24 15:42:55"},{"id":"14","title":"张海强获第十届中国青少年科技创新奖","picpath":"/uploadNews/147194123300315814.png","org":"【华东交大校团委】","content":"","view":"","type":"1","timeval":"2016-08-24 15:42:45"},{"id":"13","title":"我校学子在里约奥运会上为国争光","picpath":"/uploadNews/147194205900334324.png","org":"【华东交大体育学院】","content":"","view":"","type":"1","timeval":"2016-08-24 15:42:12"},{"id":"10","title":"首届\u201c敦煌杯\u201d中国古琴艺术展演开幕","picpath":"/uploadNews/147194180000224422.png","org":"【中青在线】","content":"","view":"","type":"1","timeval":"2016-08-24 15:42:08"}]
     */

    private String result;
    private String totalCount;
    /**
     * id : 40
     * title : 123
     * picpath : /uploadNews/148098749800418748.png
     * org : 123
     * content :
     * view : 123
     * type : 0
     * timeval : 2016-12-06 09:24:58
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

    @Override
    public String toString() {
        return "NewsBean{" +
                "eimdata=" + eimdata +
                ", result='" + result + '\'' +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }
}
