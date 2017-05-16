package com.cdsf.locman.yzy.splash;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cdsf.locman.yzy.application.BaseApplication;

/**
 * Created by wuwenliang on 2017/5/10.
 */

public class SplashApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
