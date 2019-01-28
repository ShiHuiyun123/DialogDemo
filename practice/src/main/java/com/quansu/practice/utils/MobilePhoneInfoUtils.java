package com.quansu.practice.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by Shi on 2017/10/16.
 * 获取手机相关信息
 */

public class MobilePhoneInfoUtils {
    //手机型号
    public static String getPhoneModel() {

        String handSetInfo = android.os.Build.MODEL;
        return handSetInfo;
    }


    //系统版本
    public static String getPhoneSystemVersion() {

        String handSetInfo = android.os.Build.VERSION.RELEASE;
        return handSetInfo;
    }

    //sdk版本
    public static String getPhoneSdk() {
        String handSetInfo = android.os.Build.VERSION.SDK;
        return handSetInfo;
    }

    //获取当前版本号
    public  static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo("com.muxi.ant", 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }













        }
