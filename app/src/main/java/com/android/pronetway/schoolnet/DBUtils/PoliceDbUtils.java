package com.android.pronetway.schoolnet.DBUtils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.pronetway.schoolnet.bean.RealtimeInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PoliceDbUtils {

    private PoliceDatabase helper;

    public PoliceDbUtils(Context mContext) {
        super();
        helper = new PoliceDatabase(mContext);
    }
    //插入IP和端口
    public void add(String ip, String port, String propotol) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into serverinfo (IP,port,propotol)values(?,?,?)";
        db.execSQL(sql, new Object[]{ip, port, propotol});
        closeDb(db);
    }

    //查询本地库ip地址和端口
    public List<Map<String, String>> queryAll() {
        List<Map<String, String>> list = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from serverinfo limit 1";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String ip = cursor.getString(cursor.getColumnIndex("IP"));
            String port = cursor.getString(cursor.getColumnIndex("port"));
            String propotol = cursor.getString(cursor.getColumnIndex("propotol"));
            Map<String, String> map = new HashMap<>();
            map.put("IP", ip);
            map.put("port", port);
            map.put("propotol", propotol);
            list.add(map);
        }
        closeDb(db);
        return list;
    }

    //查看数量


    public String queryAllNum(String mac) {

        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select count(*) mac from recordinfo";

        Cursor cursor = db.rawQuery(sql, null);
        ResultSet rs = (ResultSet) db.rawQuery(sql,null);
        int rowCount = 0;
        while (cursor.moveToNext()) {

            String num=cursor.getString(cursor.getColumnIndex(mac));
            rowCount++;
            return num;
        }
        closeDb(db);
        return null;
    }

    //删除本地ip信息
    public void deleteIP() {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from serverinfo";
        db.execSQL(sql, new Object[]{});
        closeDb(db);
    }


    /**
     * 保存实时信息
     */
    public void addRealtime(RealtimeInfo info) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into realtimeinfo (mac,brand,ssid,firsttime,lasttime)values(?,?,?,?,?)";
        db.execSQL(sql, new Object[]{info.getMac(), info.getBrand(), info.getMacPhone(), info.getFirsttime(), info.getLasttime()});
        closeDb(db);
    }

    /**
     * 保存布控的实时信息
     */
    public void addRecordRealtime(RealtimeInfo info) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into recordinfo (mac,brand,systime,firsttime,signaltext,recordState,lasttime)values(?,?,?,?,?,?,?)";
        db.execSQL(sql, new Object[]{info.getMac(), info.getBrand(), info.getSystime(), info.getFirsttime(), info.getSignalText(),info.getRecordState(), info.getLasttime()});
        closeDb(db);
    }


    /**
     * 更新为布控的状态
     *
     * @param //   主键
     * @param info
     */
    public void updateRealtimeInfoBy_ID(RealtimeInfo info) {
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db != null) {
            String sql = "update recordinfo set recordState=? where mac = ?;";
            Log.i("Cole", "  before" + info.getRecordState());
            Object[] obj = new Object[]{1 , info.getMac()};
            db.execSQL(sql, obj);
            Log.i("Cole", "  _after" + info.getRecordState());
        }
    }
    /**
     * 更新不是布控状态 正常状态
     *
     * @param //   主键
     * @param info
     */
    public void deleteRealtimeInfoBy_ID(RealtimeInfo info) {
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db != null) {
            String sql = "update recordinfo set recordState=? where mac = ?;";
            Object[] obj = new Object[]{0, info.getMac()};
            Log.i("Cole", "deleteRealtimeInfoBy_ID:state _before " + info.getRecordState());
            Log.i("Cole", "deleteRealtimeInfoBy_ID: mac " + info.getMac());
            db.execSQL(sql, obj);
            Log.i("Cole", "  deleteRealtimeInfoBy_ID_after" + info.getRecordState());
        }
    }


    public List<Map<String, String>> queryID() {
        List<Map<String, String>> list = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from serverinfo limit 1";//???????????
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String ip = cursor.getString(cursor.getColumnIndex("IP"));
            String port = cursor.getString(cursor.getColumnIndex("port"));
            String propotol = cursor.getString(cursor.getColumnIndex("propotol"));
            Map<String, String> map = new HashMap<>();
            map.put("IP", ip);
            map.put("port", port);
            map.put("propotol", propotol);
            list.add(map);
        }
        closeDb(db);
        return list;
    }

    /**
     * 根据 mac，band 查询布控的信息
     */
    public List<RealtimeInfo> queryAllByMacOrType(String str) {
        List<RealtimeInfo> list = new ArrayList<>();
        RealtimeInfo info = new RealtimeInfo();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from recordinfo where mac like '%%" + str + "%' or brand like '%%" + str + "%'";
        Log.i("info", sql + "@@@@@@@@@");
        Cursor cursor = db.rawQuery(sql, null);
        if(db==null)return null;
        while (cursor.moveToNext()) {
            String mac = cursor.getString(cursor.getColumnIndex("mac"));
            String brand = cursor.getString(cursor.getColumnIndex("brand"));
            String systime = cursor.getString(cursor.getColumnIndex("systime"));
            String signal = cursor.getString(cursor.getColumnIndex("firsttime"));
            String recordState = cursor.getString(cursor.getColumnIndex("recordState"));
            String lasttime = cursor.getString(cursor.getColumnIndex("lasttime"));
            info = new RealtimeInfo(mac, brand, systime, signal, recordState, lasttime);
            list.add(info);
        }
        closeDb(db);
        return list;
    }

    /**
     * 根据 mac 查询  信息
     */
    public List<RealtimeInfo> queryByMac(String str) {
        List<RealtimeInfo> list = new ArrayList<>();
        RealtimeInfo info = new RealtimeInfo();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from recordinfo where mac like '%%" + str + "%'";
        Log.i("info", sql + "@@@@@@@@@");
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String mac = cursor.getString(cursor.getColumnIndex("mac"));
            String brand = cursor.getString(cursor.getColumnIndex("brand"));
            String systime = cursor.getString(cursor.getColumnIndex("systime"));
            String signal = cursor.getString(cursor.getColumnIndex("firsttime"));
            String signaltext = cursor.getString(cursor.getColumnIndex("signaltext"));
            String recordState = cursor.getString(cursor.getColumnIndex("recordState"));
            String lasttime = cursor.getString(cursor.getColumnIndex("lasttime"));
            info = new RealtimeInfo(mac, brand, systime, signal, signaltext,recordState, lasttime);
            list.add(info);
        }

        closeDb(db);
        return list;
    }

    /**
     * 根据 mac，查询布控的信息,返回具体的实体类
     */
    public RealtimeInfo queryRecordByMacOrTypeToInfo(String str) {
        RealtimeInfo info = new RealtimeInfo();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from recordinfo where mac like '%%" + str + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        String mac = "";
        String brand = "";
        String systime = "";
        String signal = "";
        String recordState = "";
        String lasttime = "";

        while (cursor.moveToNext()) {
            mac= cursor.getString(cursor.getColumnIndex("mac"));
            brand = cursor.getString(cursor.getColumnIndex("brand"));
            systime = cursor.getString(cursor.getColumnIndex("systime"));
            signal = cursor.getString(cursor.getColumnIndex("firsttime"));
            recordState = cursor.getString(cursor.getColumnIndex("recordState"));
            lasttime = cursor.getString(cursor.getColumnIndex("lasttime"));
            if (recordState != null && recordState.equals("1")) {
                info = new RealtimeInfo(mac, brand, systime, signal, recordState, lasttime);
            } else {
                return null;
            }
        }

        closeDb(db);
        return info;
    }
    /**
     * 根据 mac，查询布控的信息,返回具体的实体类集合
     */
    public List<RealtimeInfo> queryByMacOrBandToRecordList(String str) {
        List<RealtimeInfo> list = new ArrayList<>();
        RealtimeInfo info = new RealtimeInfo();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from recordinfo where mac like '%%" + str + "%' or brand like '%%" + str + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        String mac = "";
        String brand = "";
        String systime = "";
        String signal = "";
        String recordState = "";
        String lasttime = "";

        while (cursor.moveToNext()) {
            mac= cursor.getString(cursor.getColumnIndex("mac"));
            brand = cursor.getString(cursor.getColumnIndex("brand"));
            systime = cursor.getString(cursor.getColumnIndex("systime"));
            signal = cursor.getString(cursor.getColumnIndex("firsttime"));
            recordState = cursor.getString(cursor.getColumnIndex("recordState"));
            lasttime = cursor.getString(cursor.getColumnIndex("lasttime"));
            if (info != null) {
                if (!recordState.equals("")  && recordState.equals("1")) {
                    info = new RealtimeInfo(mac, brand, systime, signal, recordState, lasttime);
                    list.add(info);
                }
            }
        }

        closeDb(db);
        return list;
    }
    /**
     * 根据 mac，查询布控的信息,返回去重的具体的实体类集合
     */
    public  Map<String, RealtimeInfo> queryByMacOrBandToRecordMap(String str) {

        Map<String,RealtimeInfo> map = new HashMap<>();
        RealtimeInfo info = new RealtimeInfo();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from recordinfo where mac like '%%" + str + "%' or brand like '%%" + str + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        String mac = "";
        String brand = "";
        String systime = "";
        String signal = "";
        String recordState = "";
        String lasttime = "";

        while (cursor.moveToNext()) {
            mac= cursor.getString(cursor.getColumnIndex("mac"));
            brand = cursor.getString(cursor.getColumnIndex("brand"));
            systime = cursor.getString(cursor.getColumnIndex("systime"));
            signal = cursor.getString(cursor.getColumnIndex("firsttime"));
            recordState = cursor.getString(cursor.getColumnIndex("recordState"));
            lasttime = cursor.getString(cursor.getColumnIndex("lasttime"));
            if (info != null) {
                if (!recordState.equals("")  && recordState.equals("1")) {
                    info = new RealtimeInfo(mac, brand, systime, signal, recordState, lasttime);
                    map.put(info.getMac(),info);

                }
            }
        }

        closeDb(db);
        return  map;
    }


    /**
     * 保存j解析的.dat文件实时信息
     */
    public void addMacOrPhoneRealtime(RealtimeInfo info) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "insert into macbybrand (macphone,brand)values(?,?)";
        db.execSQL(sql, new Object[]{info.getMacPhone(), info.getBrand()});
        closeDb(db);
    }


    public void deleteRealtime() {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from recordinfo";
        db.execSQL(sql, new Object[]{});
        closeDb(db);
    }

    public void closeDb(SQLiteDatabase db) {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }


//______________________wifi____________________
    /**
     * @param map
     */
    public void insertData(HashMap<String, String> map) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select count(*) from wf_local_ap where bssid=\'"
                + map.get("bssid") + "\'";
        Cursor rawQuery = db.rawQuery(sql, null);
        rawQuery.moveToNext();
        int count = rawQuery.getInt(0);
        String ssid = map.get("ssid");
        if (ssid != null && ssid.length() > 2) {
            ssid = map.get("ssid").substring(1, map.get("ssid").length() - 1);
        }
        if (count == 0) {
            sql = "insert into wf_local_ap(ssid,zerocode,lat,lng,bssid,type)values('"
                    + ssid
                    + "','"
                    + map.get("adcode")
                    + "',"
                    + map.get("lat")
                    + ","
                    + map.get("lng")
                    + ",'"
                    + map.get("bssid")
                    + "','"
                    + map.get("type") + "')";
            db.execSQL(sql);
        }
//		else{
//			//TODO: 更新一下wifi信息
//			sql = "update wf_local_ap set " +
//					" ssid='"+ssid+"',"
//					+" zerocode='"+map.get("adcode")+"',"
//					+" lat='"+map.get("lat")+"',"
//					+" lng='"+map.get("lng")+"',"
//					+" mobid='"+map.get("mobid")+"'"
//					+" where bssid='"+map.get("bssid")+"'";
//		}
        if (rawQuery != null)
            rawQuery.close();

    }

    public String getBssidPassWd(String bssid) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor rawQuery = db.rawQuery(
                "select passwd from wf_local_ap where bssid='?'",
                new String[] { bssid });
        rawQuery.moveToNext();
        String pwd = rawQuery.getString(0);
        rawQuery.close();
        return pwd;

    }
    public void insertData(String tempssid, String tempbssid, double templat,
                           double templng, String temppasswd, String zerocode,String type) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select count(*) from wf_local_ap where bssid='"
                + tempbssid + "'";
        Cursor rawQuery = db.rawQuery(sql, null);
        rawQuery.moveToNext();
        int count = rawQuery.getInt(0);
        if (count == 0) {
            sql = "insert into wf_local_ap(ssid,zerocode,lat,lng,bssid,type,passwd)values('"
                    + tempssid
                    + "','"
                    + zerocode
                    + "',"
                    + templat
                    + ","
                    + templng
                    + ",'"
                    + tempbssid
                    + "','"
                    + type
                    + "','"
                    + temppasswd + "')";
            db.execSQL(sql);
        }
        if (rawQuery != null)
            rawQuery.close();
    }
    public JSONArray getArray() {
        String sql = "select ssid,bssid,passwd,type,lat,lng from wf_local_ap";
        SQLiteDatabase db = helper.getWritableDatabase();
        JSONArray items = new JSONArray();
        Cursor rawQuery = null;
        try {
            rawQuery = db.rawQuery(sql, null);
            if (rawQuery != null) {
                int count = rawQuery.getCount();
                while (rawQuery.moveToNext()) {
                    JSONObject item = new JSONObject();
                    item.put("ssid",
                            rawQuery.getString(rawQuery.getColumnIndex("ssid")));
                    item.put("bssid", rawQuery.getString(rawQuery
                            .getColumnIndex("bssid")));
                    item.put("passwd", rawQuery.getString(rawQuery
                            .getColumnIndex("passwd")));
                    item.put(
                            "type",
                            rawQuery.getString(rawQuery.getColumnIndex("type")));
                    item.put("lat",
                            rawQuery.getString(rawQuery.getColumnIndex("lat")));
                    item.put("lng",
                            rawQuery.getString(rawQuery.getColumnIndex("lng")));
                    items.put(item);

                }
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (rawQuery != null)
                rawQuery.close();
        }
        return items;
    }
}
