package com.android.pronetway.schoolnet.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    /**
     * SHAREDPREF_NAME名字
     */
    private static final String SHAREDPREF_NAME = "config";
    private static SharedPreferences sharedPreferences;

    public static String ISFIRST = "is_first";

    /**
     * 存入bool值得SharedPreference
     *
     * @param context 上下文
     * @param key     key值
     * @param bool    bool值
     */
    public static void saveBoolean(Context context, String key, boolean bool) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHAREDPREF_NAME, Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putBoolean(key, bool).commit();
    }

    /**
     * 获取 bool值的SharedPreference
     * @param context 上下文
     * @param key     key值
     * @param defBool 默认值
     * @return
     */

    public static boolean getBoolean(Context context, String key, boolean defBool) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHAREDPREF_NAME, Context.MODE_PRIVATE);

        }
        return sharedPreferences.getBoolean(key, defBool);
    }

    /**
     * 设置 int值的SharedPreference
     * @param context   上下文环境
     * @param key       Key的值
     * @param number    需要保存的int类型的数据
     */
    public static void  setInteger(Context context,String key, int number){
        if(sharedPreferences==null){
            sharedPreferences = context.getSharedPreferences(SHAREDPREF_NAME,Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putInt(key,number);
    }

    /**
     * 获取int值的SharedPreference
    * @param context   上下文环境
    * @param key        Key的值
    * @param defNumber  设置默认值
    * @return
            */
    public static int  getInteger(Context context,String key, int defNumber){
        if(sharedPreferences==null){
            sharedPreferences = context.getSharedPreferences(SHAREDPREF_NAME,Context.MODE_PRIVATE);
        }
        return sharedPreferences.getInt(key,defNumber);
    }

    /**
     * 设置String类型的数据
     * @param context   上下文环境
     * @param key       Key的值
     * @param str       需要保存String的数据
     */
    public static void setString(Context context ,String key,String str){
        if (sharedPreferences==null){
            sharedPreferences =context.getSharedPreferences(SHAREDPREF_NAME,Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key,str);

    }

    /**
     * 获取String类型的数据
     * @param context   上下文环境
     * @param key        Key的值
     * @param defString 默认的String类型的数据
     * @return
     */
    public static String getString(Context context ,String key,String defString){
        if(sharedPreferences==null){
            sharedPreferences =context.getSharedPreferences(SHAREDPREF_NAME,Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key,defString);
    }


}
