package com.example.exp3new;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {
    // 该程序模拟填充长度为100的数组
    private int[] data = new int[100];
    int hasData = 0;
    // 定义进度对话框的标识
    // final int PROGRESS_DIALOG = 0x112;
    // 记录进度对话框的完成百分比
    int progressStatus = 0;
    ProgressBar pb;
    TextView progress_tv;//显示进度条完成百分比
    // 定义一个负责更新的进度的Handler

    //Handler消息处理，请补全代码，是多行。
    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == 0x111)
            {
                pb.setProgress(progressStatus);
                progress_tv.setText(progressStatus+"%");
                progressStatus++;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        pb = findViewById(R.id.pb1);
        progress_tv = findViewById(R.id.pg_tv);
        new Thread()
        {
            public void run()
            {
                while (progressStatus < 100){
                    //获取耗时操作的完成百分比
                    progressStatus = doWork();
                    //发送消息
                    handler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }


    // 模拟一个耗时的操作。
    public int doWork() {
        // 为数组元素赋值
        data[hasData++] = (int) (Math.random() * 100);
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
