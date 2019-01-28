package com.quansu.practice.utils;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NavigationBar {


    /**
     * @param context
     * @param tv
     * 注意最外层是 LinearLayout
     */
    public static void initNavigationBar(Context context, TextView tv){

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {//不支持沉浸式状态栏
            tv.setVisibility(View.GONE);
            return;
        } else {
            //获取状态栏的高度
            int statusBarHeight = UiUtils.getStatusBarHeight(context);

            //动态设置高度  tv
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv.getLayoutParams();
            //获取当前控件的布局对象
            //params.height=UiUtils.dp2dip(getContext(), statusBarHeight);//设置当前控件布局的高度
            params.height = statusBarHeight;
            tv.setLayoutParams(params);//将设置好的布局参数应用到控件中

            tv.setVisibility(View.VISIBLE);

        }

    }

}
