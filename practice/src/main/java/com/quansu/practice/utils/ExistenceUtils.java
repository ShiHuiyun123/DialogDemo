package com.quansu.practice.utils;

import android.app.Activity;
import android.os.Build;

/**
 * Created by Shi on 2017/9/28.
 */

public class ExistenceUtils {

    public static boolean isExistence(Activity a){//判断当前的activity是否存在

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            if(a.isFinishing()||a.isDestroyed()){

                return  true;//不存在了
            }

        }else{
            if(a.isFinishing()){//不存在了
                return  true;
            }
        }

        return  false;//还存在
    }

}
