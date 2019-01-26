package com.quansu.dialogdemo.utils;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.quansu.dialogdemo.R;
import com.quansu.dialogdemo.dialog.TwoYDialog;

public class TestDialog extends TwoYDialog {

    public TestDialog(Context context) {
        super(context);
        setStyle(CENTER);

    }

    @Override
    protected void initView(View view) {

        Button but=view.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    @Override
    public int provideLayoutId() {
        return R.layout.test_dialog;
    }
}
