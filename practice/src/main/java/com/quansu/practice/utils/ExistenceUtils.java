package com.quansu.practice.utils;

import android.app.Activity;
import android.os.Build;

/**
 * Created by Shi on 2017/9/28.
 */

public class ExistenceUtils {

    public static boolean isExistence(Activity a){//Determine whether the current activity exists

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            if(a.isFinishing()||a.isDestroyed()){

                return  true;//Does not exist.
            }

        }else{
            if(a.isFinishing()){//Does not exist.
                return  true;
            }
        }

        return  false;//Still exist
    }

}
