package com.quansu.practice.utils;

import java.util.HashMap;

/**
 * Created by xianguangjin on 16/8/6.
 */

public class ParamsUtils {
    private static ParamsUtils mapUtils;

    private static HashMap<String, Object> params;

    public static ParamsUtils init() {
        if (mapUtils == null) {
            mapUtils = new ParamsUtils();
        }
        params = new HashMap<>();

        return mapUtils;
    }

    public static ParamsUtils put(String key, Object value) {

        params.put(key, value);
        return mapUtils;
    }

    public static HashMap<String, Object> ok() {
        return params;
    }

}
