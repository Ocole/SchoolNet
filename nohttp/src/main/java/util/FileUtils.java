package util;

import android.os.Environment;

/**
 * Created by 袁慎彬 on 2016/7/11.
 */
public class FileUtils {

    /**
     * 判断是否有SD卡
     */
    public static boolean isExistSDCard() {
        return Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 返回手机内存路径优先内存卡
     *
     * @return
     */
    public static String getCachePath() {
        if (isExistSDCard()) {
            return Environment.getExternalStorageDirectory() + "/jacky/";
        } else {
            return "/data" + "/jacky/";
        }
    }
}
