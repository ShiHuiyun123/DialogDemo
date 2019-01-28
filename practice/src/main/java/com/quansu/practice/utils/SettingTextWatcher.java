package com.quansu.practice.utils;

import android.content.Context;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;


import com.quansu.practice.R;

import java.util.regex.Pattern;

/**
 * Created by weihuagu on 2017/11/18.
 */

public class SettingTextWatcher implements TextWatcher {


    private int editStart ;
    private int editCount ;
    private EditTextPreference mEditTextPreference;
    int minValue;
    int maxValue;
    private Context mContext;

    public SettingTextWatcher(Context context,EditTextPreference e,int min, int max) {
        mContext = context;
        mEditTextPreference = e;
        minValue = min;
        maxValue = max;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        editStart = i;
        editCount = i2;
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (TextUtils.isEmpty(s)) {
            return;
        }
        String content = s.toString();
//		Log.e("demo", "content:"+content);
        if (isNumeric(content)) {
            int num = Integer.parseInt(content);
            if (num > maxValue || num < minValue) {
                s.delete(editStart, editStart+editCount);
                mEditTextPreference.getEditText().setText(s);
                Toast.makeText(mContext, mContext.getString(R.string.beyond_the_valid_value_range), Toast.LENGTH_SHORT).show();
            }
        }else {
            s.delete(editStart, editStart+editCount);
            mEditTextPreference.getEditText().setText(s);
            Toast.makeText(mContext, mContext.getString(R.string.you_can_only_enter_numbers), Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Regular Expressions - Determine whether it is a number
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
