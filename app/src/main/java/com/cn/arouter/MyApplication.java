package com.cn.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by ${qsh} on 2017/7/20.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
