package com.android.pronetway.schoolnet.DBUtils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PoliceDatabase extends SQLiteOpenHelper {


	//参数设置
	private static String DB_NAME="police.db";
	private static int DB_VERSION=1;
	// 定义全局的SQLiteDatabase
	private SQLiteDatabase db;

	public PoliceDatabase(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 进行数据库的连接
	 */
	public void getConn() {
		// getWritableDatabase和getReadableDatabase
		// 1.共同点:都是对数据库进行可读写的操作:
		// a.如果第一次创建数据库,会调用onCreate和onOpen的方法
		// b.如果不是第一次创建数据库,直接调用onOpen的方法
		// c.如果数据库版本发生改变的时候会调用onUpgrade和onOpen的方法
		// 2.不同点:getWritableDatabase磁盘满的时候在录入数据会报错,直接throw抛错,数据会被加锁
		// getReadableDatabase磁盘满的时候录入失败,直接结束
		// db = getWritableDatabase(); //打开连接的方法
		db = getReadableDatabase(); // 打开连接的方法 (推荐使用readable)
	}
	@Override
	public void onOpen(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		super.onOpen(db);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sqlwifi = "create table if not exists " +
				"wf_local_ap (recno int auto_increment primary key," +
				"ssid char(128)," +
				"zerocode char(32)," +
				"bssid char(32) unique," +
				"apmac char(24)," +
				"passwd char(24)," +
				"mobid char(128)," +
				"type char," +
				"modtime int," +
				"moduser char(24)," +
				"content char(128)," +
				"lat double," +
				"lng double)";

		String sql="create table serverinfo (id integer primary key autoincrement ,"
				+ "IP varchar(255),port varchar(255),propotol varchar(255))";
		db.execSQL(sql);
		db.execSQL(sqlwifi);
		Log.d("sqlites", "———————————数据库创建成功");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
