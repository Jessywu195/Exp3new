package com.example.exp3new;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigurationActivity extends AppCompatActivity {
    EditText ori;
    EditText navigation;
    EditText touch;
    EditText mnc;
    Button btn_back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        // 获取应用界面中的界面组件
        ori = findViewById(R.id.ori);
        navigation = findViewById(R.id.navigation);
        touch = findViewById(R.id.touch);
        mnc = findViewById(R.id.mnc);
        Button bn = findViewById(R.id.bn);
        // 为按钮绑定事件监听器
        bn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View source) {
                // 获取系统的Configuration对象
                Configuration cfg = getResources().getConfiguration();
                String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕": "竖向屏幕";
                String mncCode = cfg.mnc + "";
                String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV ? "没有方向控制": cfg.orientation == Configuration.NAVIGATION_WHEEL ? "滚轮控制方向": cfg.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制方向": "轨迹球控制方向";
                navigation.setText(naviName);
                String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH ? "无触摸屏": cfg.touchscreen == Configuration.TOUCHSCREEN_STYLUS ? "触摸笔式触摸屏": "接受手指的触摸屏";
                ori.setText(screen);
                mnc.setText(mncCode);
                touch.setText(touchName);
            }
        });

     btn_back = findViewById(R.id.btn_back);
     btn_back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(ConfigurationActivity.this,MainActivity.class);
             startActivity(intent);
         }
     });
    }
}

