package com.quansu.practice.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by xianguangjin on 15/7/15.
 */
public class StringUtil {


    public static boolean isEmpty(String str) {

        return null == str || "".equals(str);
    }


    /**
     * Returns the current program version name
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        int versioncode = 0;
        try {
            // ---netInstance the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
        }
        return versionName;
    }

    /**
     * Returns the current program version name
     */
    public static int getAppVersionCode(Context context) {
        String versionName = "";
        int versioncode = 0;
        try {
            // ---netInstance the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return 0;
            }
        } catch (Exception e) {
        }
        return versioncode;
    }


    /**
     * Mobile phone number verification
     *
     * @param str
     *
     * @return Verify by returning true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8,7][0-9]{9}$");
        m = p.matcher(str);
        b = m.matches();

        return b;
    }


    /**
     * Change from DP unit to PX (pixel) according to the resolution of mobile phone
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static boolean equal(Object str, Object str_2) {
        return str.equals(str_2);
    }


    public static String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto;} body{ background-color: #ffffff;font-size:large;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }


    public static String setterName(String name) {

        if (name == null || name.isEmpty()) {

            return "";
        } else {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }


    /**
     *
     *
     * @param context
     * @param url
     */
    public static void handleUrl(Context context, String url) {
        try {
            Intent intent;
            if (url.contains("?")) {
                if (url.contains("switch_fragment")) {
//                    bus().post(Msg.SWITCH_FRAGMENT);
                } else {

                    Log.e("asjakf","---"+StringUtil.getPureUrl(url));

                    intent = new Intent(context, Class.forName(StringUtil.getPureUrl(url)));
                    Bundle urlBundle = StringUtil.getUrlBundle(url);
                    intent.putExtras(urlBundle);
                    context.startActivity(intent);
                }
            } else {
                intent = new Intent(context, Class.forName(url));
                context.startActivity(intent);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rejection parameter
     *
     * @param url
     *
     * @return
     */
    public static String getPureUrl(String url) {
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }

        return url;
    }

    /**
     * Converting the parameters contained in the URL to bundle objects
     *
     * @param url
     *
     * @return
     */

    public static Bundle getUrlBundle(String url) {
        Map<String, String> params = getParams(url);
        Iterator<String> iterator = params.keySet().iterator();
        Bundle bundle = new Bundle();
        while (iterator.hasNext()) {
            String next = iterator.next();
            bundle.putString(next, params.get(next));
        }
        return bundle;
    }

    /**
     * Get all the parameters in the URL
     *
     * @param url
     *
     * @return
     */





    public static Map<String, String> getParams(String url) {
        if (url.contains("&") && url.contains("?")) {
            url = url.substring(url.indexOf("?") + 1, url.length());
        } else if (url.contains("?")) {
            url = url.substring(url.indexOf("?") + 1, url.length());
        }

        String[] params = url.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value;
            try {
                 value = param.split("=")[1];

            }catch (Exception e){
                value="";
            }

            map.put(name, value);
        }
        return map;
    }


}
