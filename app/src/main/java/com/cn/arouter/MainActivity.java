package com.cn.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/app/maintivity")
public class MainActivity extends AppCompatActivity {
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        tvContent = (TextView) findViewById(R.id.arouter_text);
        if (intent != null){
            tvContent.setText(intent.getStringExtra("0x001"));
        }else {
            tvContent.setText("传值失败");
        }

    }



    public void btnClick(View view){
        switch (view.getId()) {
            case R.id.btn1:
                Log.d("print","123");
//                ARouter.getInstance().build("/mode/2").navigation();
//                ARouter.getInstance().build("/module/1").navigation();
                Intent intent = new Intent();
                intent.setClassName(this, "com.cn.libraryone.MainActivity");
                intent.putExtra("0x001","传过去了");
                startActivity(intent);
                break;
            case R.id.btn2:
                ARouter.getInstance().build("/libraryone/testactivity").navigation();
                break;
            case R.id.btn3:
//                ARouter.getInstance().build("/mode/2").navigation();
                intent = new Intent(this,MainActivity2.class);
                intent.putExtra("0x001","intent跳转");
                startActivity(intent);
                break;
            case R.id.btn4:
                ARouter.getInstance().build("/myLibrary/mainActivity").navigation();
                break;
        }
    }

}
