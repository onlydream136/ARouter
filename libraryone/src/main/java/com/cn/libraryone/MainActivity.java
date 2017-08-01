package com.cn.libraryone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by ${qsh} on 2017/7/20.
 */

@Route(path = "/module/1")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("0x001");
        Log.d("print",name);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn){
            Intent intent = new Intent();
            intent.setClassName(this, "com.cn.arouter.MainActivity");
            intent.putExtra("0x001","LibraryOne传过来的值");
            startActivity(intent);
        }
        if (v.getId() == R.id.btn5){
            UerModel model = new UerModel();
            model.setName("张三");
            model.setSix("男");
            ARouter.getInstance().build("/testmain/mainActivity2")
                    .withString("0x001","Arouter跳转")
                    .withSerializable("ser",model)
                    .navigation();
        }
    }
}
