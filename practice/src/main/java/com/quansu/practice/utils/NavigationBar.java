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
     * Note that the outermost layer is LinearLayout
     */
    public static void initNavigationBar(Context context, TextView tv){

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {//Immersion status bar is not supported
            tv.setVisibility(View.GONE);
            return;
        } else {
            //Get the height of the status bar
            int statusBarHeight = UiUtils.getStatusBarHeight(context);

            //Dynamic height setting  tv
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv.getLayoutParams();
            //Gets the layout object of the current control
            //params.height=UiUtils.dp2dip(getContext(), statusBarHeight);//Set the height of the current control layout
            params.height = statusBarHeight;
            tv.setLayoutParams(params);//Apply the set layout parameters to the control

            tv.setVisibility(View.VISIBLE);

        }

    }

}
