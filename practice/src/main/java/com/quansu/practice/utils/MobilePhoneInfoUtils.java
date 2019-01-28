package com.quansu.practice.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by Shi on 2017/10/16.
 * Get information about mobile phones
 */

public class MobilePhoneInfoUtils {
    //Mobile phone model
    public static String getPhoneModel() {

        String handSetInfo = android.os.Build.MODEL;
        return handSetInfo;
    }


    //System version
    public static String getPhoneSystemVersion() {

        String handSetInfo = android.os.Build.VERSION.RELEASE;
        return handSetInfo;
    }

    //SDK version
    public static String getPhoneSdk() {
        String handSetInfo = android.os.Build.VERSION.SDK;
        return handSetInfo;
    }

    //Get the current version number
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
