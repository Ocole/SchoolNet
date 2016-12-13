package com.android.pronetway.schoolnet.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

/**
 * Created by Coleman on 2016/11/22.
 */

public class WifiConnect {
    private static final String TAG = "WifiConnect";
    private static final String CWIFI = "ProCap100";
    //定义WifiManager对象
    private  WifiManager mWifiManager;
    // 定义WifiInfo对象
    private WifiInfo mWifiInfo;
//    private AccessPoint mAccessPoint;
    private ScanResult mresult;
    private Context mcontext;

    //构造函数
    public WifiConnect(Context context){
        mcontext = context;
        // 取得WifiManager对象
        mWifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        // 取得WifiInfo对象
        mWifiInfo = mWifiManager.getConnectionInfo();
    }

    //打开wifi功能
    private boolean OpenWifi(){
        boolean bRet = true;
        if (!mWifiManager.isWifiEnabled()){
            bRet = mWifiManager.setWifiEnabled(true);
        }
        return bRet;
    }

    //从扫描结果中提取需要的wifi
    private boolean getScanResultsBySSID(String ssid){
        List<ScanResult> list = mWifiManager.getScanResults();
        for (ScanResult result : list){
            if (TextUtils.equals(result.SSID, ssid)){
                mresult=result;
                return true;
            }
        }
        return false;
    }

    //查看以前是否也配置过这个网络
    private WifiConfiguration IsExsits(String SSID){
        List<WifiConfiguration> existingConfigs = mWifiManager.getConfiguredNetworks();
        for (WifiConfiguration existingConfig : existingConfigs) {
            if (existingConfig.SSID.equals("\""+SSID+"\"")){
                return existingConfig;
            }
        }
        return null;
    }

    //提供一个外部接口，传入要连接的无线网
    public boolean Connect(String SSID, String Password)
    {
        if(!this.OpenWifi())
        {
            return false;
        }
        //开启wifi功能需要一段时间(我在手机上测试一般需要1-3秒左右)，所以要等到wifi
        //状态变成WifiManager.WIFI_STATE_ENABLED的时候才能执行下面的语句
        while( !(mWifiManager.getWifiState()==WifiManager.WIFI_STATE_ENABLED) )
        {
            try{
                //为了避免程序一直while循环，让它睡个100毫秒在检测……
                Thread.currentThread();
                Thread.sleep(100);
            }
            catch(InterruptedException ie){
            }
        }
        Log.i(TAG, "---BeginScan-SSID---");
        //等待扫描完wifi
        while( !getScanResultsBySSID(SSID) )
        {
            try{
                //为了避免程序一直while循环，让它睡个100毫秒在检测……
                Thread.currentThread();
                Thread.sleep(100);
            }
            catch(InterruptedException ie){
            }
        }
        Log.i(TAG, "---EndScan-SSID---");
        WifiConfiguration config = new WifiConfiguration();
//        mAccessPoint = new AccessPoint(mcontext,mresult);
        //判断以前是否保存过此WIFI环境
        WifiConfiguration tempConfig = this.IsExsits(SSID);
        if(tempConfig != null){
            mWifiManager.removeNetwork(tempConfig.networkId);
        }
//        config = mAccessPoint.getConfig(Password, null, null);
        Log.i(TAG, "----wifi--config--"+config);
        int netID = mWifiManager.addNetwork(config);
        boolean bRet = mWifiManager.enableNetwork(netID,false);
        if(bRet){
            //保持WIFI配置文件
            mWifiManager.saveConfiguration();
        }
        Log.i(TAG, "------WifiConnectState---"+bRet);
        return bRet;
    }
}
