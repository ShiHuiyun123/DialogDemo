package com.quansu.dialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.quansu.dialogdemo.utils.TestDialog;
import com.quansu.practice.MyView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       //initView();

        View v = new MyView(this);
        setContentView(v);

    }

    private void initView() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹框

                new TestDialog(MainActivity.this).show();
            }
        });
    }
}
