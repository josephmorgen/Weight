package com.example.administrator.weight;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Result extends Activity{
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        /*加载布局layout*/
        setContentView(R.layout.result);
        /*获取intent中的bundle*/
        Bundle bundle1=this.getIntent().getExtras();
        /*获取bundle1中的数据*/
        String sex=bundle1.getString("sex");
        double height=bundle1.getDouble("height");
        /*判断性别*/
        String sexText="";
        double weight;
        if(sex.equals("Male"))
        {
            sexText="男性";
        } else{
            sexText="女性";
        }
        if(sexText.equals("男性")){
            weight=(height-80)*0.7;
        }else{
            weight=(height-70)*0.6;
        }
        /*输出结果*/
        TextView tv=(TextView)findViewById(R.id.textInput);
        tv.setText("你是一位"+sexText+"\n你的身高是"+height+"cm\n你的标准体重是"+weight+"kg");
    }
}
