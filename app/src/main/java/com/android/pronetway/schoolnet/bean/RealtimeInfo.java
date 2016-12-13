package com.android.pronetway.schoolnet.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealtimeInfo implements Serializable {
    private String mac = "";
    private String macPhone = "";
    private String brand = "";
    private String ssid = "";
    private String systime = "";
    private String recordState = "";//是否备案记录的标志  1 已经备案     ，   0 未备案
    private String firsttime = "";
    private String allTime = "";

    private String signal = "";
    private String signalText = "";

    private String lasttime = "";

    public RealtimeInfo() {
        super();
    }

    public String getSignalText() {
        return signalText;
    }

    public RealtimeInfo(String allTime, String brand, String firsttime, String lasttime, String mac, String macPhone, String recordState, String signal, String signalText, String ssid, String systime) {
        this.allTime = allTime;
        this.brand = brand;
        this.firsttime = firsttime;
        this.lasttime = lasttime;
        this.mac = mac;
        this.macPhone = macPhone;
        this.recordState = recordState;
        this.signal = signal;
        this.signalText = signalText;
        this.ssid = ssid;
        this.systime = systime;
    }

    public void setSignalText(String signalText) {
        this.signalText = signalText;
    }

    public String getAllTime() {
        return allTime;
    }

    public void setAllTime(String allTime) {
        this.allTime = allTime;
    }

    public RealtimeInfo(String mac, String brand, String systime, String firsttime,String recordState,
                        String lasttime) {
        super();
        this.mac = mac;
        this.brand = brand;
        this.systime = systime;
        this.firsttime = firsttime;
        this.recordState = recordState;
        this.lasttime = lasttime;
    }
    public RealtimeInfo(String mac, String brand, String systime, String firsttime, String signaltext,String recordState,
                        String lasttime) {
        super();
        this.mac = mac;
        this.brand = brand;
        this.systime = systime;
        this.firsttime = firsttime;
        this.signalText = signaltext;
        this.recordState = recordState;
        this.lasttime = lasttime;
    }

    public RealtimeInfo(String mac, String brand, String ssid, String firsttime,
                        String lasttime) {
        super();
        this.mac = mac;
        this.brand = brand;
        this.ssid = ssid;
        this.firsttime = firsttime;
        this.lasttime = lasttime;
    }

    public RealtimeInfo(String mac, String brand, String signal,
                        String lasttime) {
        super();
        this.mac = mac;
        this.brand = brand;
        this.firsttime = signal;
        this.lasttime = lasttime;
    }

    public RealtimeInfo(String macPhone, String brand) {
        super();
        this.macPhone = macPhone;
        this.brand = brand;

    }

    public RealtimeInfo(String brand) {
        super();
        this.brand = brand;

    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public String getSsid() {
        if (ssid == null) {
            return "";
        }
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getRecordState() {
        if (recordState == null) {
            return "0";
        }
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState;
    }

    public String getSystime() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        String sysTimeval = format.format(date1);

        return systime;
    }

    public void setSystime(String systime) {
        this.systime = systime;
    }

    public String getMac() {
        if (mac == null) {
            return "";
        }
        return mac;
    }

    public String getMacPhone() {

        if (macPhone == null) {
            return "";
        }
        return macPhone;
    }

    public void setMacPhone(String macPhone) {
        this.macPhone = macPhone;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getBrand() {
        if (brand == null) {
            return "";
        }
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    @Override
    public String toString() {
        return "RealtimeInfo{" +
                "brand='" + brand + '\'' +
                ", mac='" + mac + '\'' +
                ", macPhone='" + macPhone + '\'' +
                ", systime='" + systime + '\'' +
                ", recordState='" + recordState + '\'' +
                ", firsttime='" + firsttime + '\'' +
                ", lasttime='" + lasttime + '\'' +
                '}';
    }
}
