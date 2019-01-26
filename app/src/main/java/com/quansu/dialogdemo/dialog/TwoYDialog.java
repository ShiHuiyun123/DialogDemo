package com.quansu.dialogdemo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.quansu.dialogdemo.R;

/**
 * Created by Shi on 2018/3/28.
 */

public abstract class TwoYDialog implements DialogInter{

    private Context _context;
    public int style = BOTTOM;
    public Dialog _Dialog;
    public View _Layout;
    public final static int BOTTOM = 1;
    public final static int CENTER = 2;
    public final static int TOP = 3;
    public final static int TOP_RIGHT = 4;

    public TwoYDialog(Context context) {
        this._context = context;

    }
    public TwoYDialog init() {
        LayoutInflater layoutInflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _Layout = layoutInflater.inflate(provideLayoutId(), null);

        _Dialog = new Dialog(_context, getStypeRes());


        _Dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        _Dialog.setContentView(_Layout);

        Window win = _Dialog.getWindow();
        win.getDecorView().setPadding(0,getPaddingTop(),0, getPaddingBotoom());

        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;

        int screenHeight = getScreenHeight();
        int statusBarHeight = getStatusBarHeight();
        int dialogHeight = screenHeight - statusBarHeight;
        lp.height =dialogHeight==0? WindowManager.LayoutParams.MATCH_PARENT:dialogHeight;//这么设置的原因是全屏的时候手机顶部导航栏变黑。

        lp.gravity = getGravity();
        lp.windowAnimations = getAnimation();
        win.setAttributes(lp);
        _Dialog.setCanceledOnTouchOutside(true);
        _Dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {


                return false;
            }
        });

        initView(_Layout);
        return this;
    }

    //设置高度
   public int getScreenHeight(){
       DisplayMetrics displaymetrics = new DisplayMetrics();
       ((Activity)_context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
       return displaymetrics.heightPixels;
   }

   public int getStatusBarHeight(){
       int statusBarHeight = 0;
       Resources res =  ((Activity)_context).getResources();
       int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
       if (resourceId > 0) {
           statusBarHeight = res.getDimensionPixelSize(resourceId);
       }
       return statusBarHeight;

   }

    protected int getPaddingBotoom() {
        return 0;
    }

    protected int getPaddingTop() {
        return 0;
    }

    /**
     * 获取左右边距
     *
     * @return
     */
    protected int getPaddingLeft() {
        return 20;
    }

    /**
     * 初始化View,需要在构造函数里调用
     *
     * @param view
     */
    protected abstract void initView(View view);


    /**
     * 位置
     *
     * @return
     */
    private int getGravity() {
        switch (style) {
            case BOTTOM:
                return Gravity.BOTTOM;
            case CENTER:

                return Gravity.CENTER;
            case TOP:
                return Gravity.TOP;
            case TOP_RIGHT:
                return Gravity.RIGHT;
        }
        return Gravity.BOTTOM;
    }

    /**
     * 获取动画
     *
     * @return
     */
    private int getAnimation() {
        switch (style) {
            case BOTTOM:
                return R.style.dialogAnim;
            case CENTER:

                return R.style.dialogAnimCenter;
            case TOP:
                return R.style.dialogAnimTop;
        }

        return R.style.dialogAnim;
    }

    /**
     * 获取类型
     *
     * @return
     */
    private int getStypeRes() {

        switch (style) {
            case BOTTOM:
                return R.style.dialog;
            case CENTER:
                return  R.style.dialog_progress;
            case TOP:
                return R.style.dialog_top;
        }

        return R.style.dialog;
    }

    /**
     * 提供布局
     *
     * @return
     */
    public abstract int provideLayoutId();


    /**
     * 展示
     */
    @Override
    public DialogInter show() {
        if (_Dialog == null) {
            init();
        }
        _Dialog.show();
        return this;
    }


    /**
     * 消失
     */
    @Override
    public void dismiss() {
        if (_Dialog != null) {
            _Dialog.dismiss();
        }
    }


    public Dialog getDialog() {
        return _Dialog;
    }


    public TwoYDialog setStyle(int style) {
        this.style = style;
        return this;
    }
}
