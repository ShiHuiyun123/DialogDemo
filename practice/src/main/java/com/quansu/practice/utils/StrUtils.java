package com.quansu.practice.utils;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by xianguangjin on 16/8/2.
 * <p>
 * 我的GitHub: https://github.com/ysnows
 * <p>
 * 加油,做一个真的汉子
 */

public class StrUtils {

    public static String jsonStrWith(ArrayList<String> list, String code) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
            builder.append(code);
        }
        String toString = builder.toString();
        String substring = toString.substring(0, toString.length() - 1);
        return substring;
    }

    public static String getEdtContent(EditText editText) {
        return getEdtContent(editText, null);
    }

    public static String getEdtContent(EditText editText, int tipResId) {
        return getEdtContent(editText, editText.getContext().getString(tipResId));
    }

    public static String getEdtContent(EditText editText, String string) {
        String content = editText.getText().toString().trim();
        if (!TextUtils.isEmpty(content)) {
            return content;
        } else {
            if (!TextUtils.isEmpty(string)) {
                Toast.makeText(editText.getContext(),string ,Toast.LENGTH_SHORT).show();

            }
            return content;
        }
    }

}
