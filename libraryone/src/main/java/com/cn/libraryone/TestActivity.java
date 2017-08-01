package com.cn.libraryone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by ${qsh} on 2017/7/20.
 */
@Route(path = "/libraryone/testactivity")
public class TestActivity extends AppCompatActivity {
    private String html = "<a href=\"zezeze://m.aliyun.com/app/maintivity?0x001=alex&six=男\">URL跳转</a>\n" +
            "<a href=\"zezeze://m.aliyun.com/testmain/mainActivity2?0x001=alex&six=女\">URL跳转</a>\n";
    private WebView webView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test);
         webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setDefaultTextEncodingName("UTF -8") ;
        webView.loadData(html, "text/html; charset=UTF-8", null);
    }

}
