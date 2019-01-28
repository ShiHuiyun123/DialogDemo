package com.quansu.practice.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by xianguangjin on 16/8/9.
 */

public class SDUtils {

    public static boolean ExistSDCard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }


    public static long getSDFreeSize(){

        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long freeBlocks = sf.getAvailableBlocks();

        return (freeBlocks * blockSize)/1024 /1024;
    }


    public static long getSDAllSize(){
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long allBlocks = sf.getBlockCount();

        return (allBlocks * blockSize)/1024/1024;
    }


}
