package com.cdsf.locman.yzy.splash

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.cdsf.locman.yzy.provider.LocManProvider
import kotlinx.android.synthetic.main.splash_activity_splash.*

/**
 * Created by wuwenliang on 2017/5/9.
 */

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity_splash)
        startSplash()
    }
    private fun startSplash() {
        val animation = AlphaAnimation(1.0f, 1.0f)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }
            override fun onAnimationEnd(animation: Animation) {
/*                val appPreferences = AppPreferences(this@SplashActivity)
                val pwd = appPreferences.get(AppPreferences.USERPASSWORD)
                if (TextUtils.isEmpty(pwd)) {
                    //需要进入登陆界面
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                } else {
                    //进入主页
                    startActivity(Intent(this@SplashActivity, OrderHomeActivity::class.java))
                }
                finish()*/
                ARouter.getInstance().build(LocManProvider.PROVIDER_OFFLINE_MAP).greenChannel().navigation(this@SplashActivity, object : NavCallback() {
                    override fun onFound(postcard: Postcard?) {
                        Log.d("ARouter", "找到了")
                    }

                    override fun onLost(postcard: Postcard?) {
                        Log.d("ARouter", "找不到了")
                    }

                    override fun onArrival(postcard: Postcard) {
                        Log.d("ARouter", "跳转完了")
                    }

                    override fun onInterrupt(postcard: Postcard?) {
                        Log.d("ARouter", "被拦截了")
                    }
                });
                //finish()

            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
        animation.duration = 2000
        splash_imageview.startAnimation(animation)
    }
}
