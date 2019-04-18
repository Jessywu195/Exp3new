package com.example.exp3new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn7,btn8;
    TextView show;
    @BindView(R.id.btn_6)
    Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);//ButterKnife

        show = findViewById(R.id.txtv);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);

        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ConfigurationActivity.class);
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProgressBarActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(this);//使用Activity作为监听器
        btn2.setOnClickListener(new View.OnClickListener() {//匿名内部类
            @Override
            public void onClick(View v) {
                show.setText("匿名内部类");
            }
        });

        btn4.setOnClickListener(new MyInClickListner()) ;//内部类
        btn5.setOnClickListener(new MyOnClickListener(this,show));//外部类
    }//OnCreate

class MyInClickListner implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            show.setText("内部类");
        }
    }

    @OnClick(R.id.btn_6)
    public void onButtonClick()
    {
        show.setText("ButterKnife");
    }

    @Override
    public void onClick(View view)
    {
        show.setText("Activity作为监听器");
    }//使用Activity作为监听器

    public void clickHandler(View source)
    {
        show.setText("绑定到标签");
    }//绑定到标签方式实现监听

}//Activity


class MyOnClickListener implements View.OnClickListener {
    private AppCompatActivity act;
    private TextView show2;
    MyOnClickListener(AppCompatActivity act, TextView show)
    {
        this.act = act;
        this.show2 = show;
    }
    @Override
    public void onClick(View view)
    {
        show2.setText("外部类");
    }
}
