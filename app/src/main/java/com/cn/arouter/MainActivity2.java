package com.cn.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cn.libraryone.UerModel;

/**
 * Created by ${qsh} on 2017/7/31.
 */

@Route(path = "/testmain/mainActivity2")
public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    @Autowired(name = "0x001")
    public String str;
    @Autowired(name = "obj")
    public UerModel obj;
    @Autowired(name = "ser")
    public UerModel ser;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ARouter.getInstance().inject(this);
        textView = (TextView) findViewById(R.id.tv);
        Intent intent = getIntent();
        if (intent != null){
//            str = intent.getStringExtra("0x001");
//            ser = (UerModel) intent.getSerializableExtra("ser");
        }
        textView.setText(str);
//        Log.d("print",ser.getName()+ser.getSix());
    }
}
