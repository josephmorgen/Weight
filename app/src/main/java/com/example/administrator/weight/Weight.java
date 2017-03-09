package com.example.administrator.weight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View.OnClickListener;

public class Weight extends AppCompatActivity {
    public static String sex="Male";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*载入布局weight */
        setContentView(R.layout.weight);
        /*取得xml内的按钮*/
        Button b1 =(Button) findViewById(R.id.btnWork);
        /*获得用户填写的高度*/
        EditText et =(EditText)findViewById(R.id.etWeight);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                /*获得用户填写的高度*/
                EditText et =(EditText)findViewById(R.id.etWeight);
                double height=Double.parseDouble(et.getText().toString());
                /*获得性别*/
                RadioGroup rg=(RadioGroup)findViewById(R.id.rgSex);
                rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int i) {
                        if(i==R.id.rbMale)
                            sex="Male";
                        else{
                            sex="Female";
                        }
                    }
                });
                /*新建一个Intent对象*/
                Intent intent=new Intent();
                intent.setClass(Weight.this,Result.class);
                /*新建一个Bundle对象以传入数据*/
                Bundle bundle=new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                /*将bundle分配给intent*/
                intent.putExtras(bundle);
                /*调用activity*/
                startActivity(intent);
            }
        });

        }
    }

