package com.android.pronetway.schoolnet.bean;

public class P {
	public static final String HTTP ="http://" ;
	public static String PROPOTOL="http";
	public static String IP="192.168.20.154";
	public static  String PORT=":8006";
	/**
	 * 登录接口
	 * 验证登录======http://192.168.20.154:8006/pronline/Msg?FunName=ict_check_pass_new&vname=18055835997&pass=168387
	 * 192.168.20.154:8006/wap/login.html
	 * http://192.168.20.154:8006/pronline/Msg?FunName=ict_Auth_New&vname=admin1&passwd=admin123
	 */
	/**
	 * 获取验证码
	 * 短信验证======http://192.168.20.154:8006/pronline/Msg?FunName=ictSrvGetPassNew&phoneno=18055835997
	 */
	public static final String GET_SMS="/pronline/Msg?FunName=ictSrvGetPassNew";


	/**
	 * 获新闻的详情
	 * http://192.168.20.154:8006/pronline/Msg?FunName@ict_school_indexNews&page=1&dir=1&start=1&type=&limit=10
	 */
	public static final String GET_NEWS_DETAILINFO="/pronline/Msg?FunName@ict_school_indexNews";
	public static final String GET_NEWS_DETAIL="/wap/newsDetails.html?id=";


	/**
	 * 验证登录======http://192.168.20.154:8006/pronline/Msg?FunName=ict_check_pass_new&vname=18055835997&pass=168387
	 */
	public static final String CHECK_LOGIN="/pronline/Msg?FunName=ict_check_pass_new";

	/**
	 * 检测网络是否连接的参数
	 */
	public static String CheckIp = "222.73.136.209";
	public static int CheckPort = 6022;

	public static String linkssid = "";
}
