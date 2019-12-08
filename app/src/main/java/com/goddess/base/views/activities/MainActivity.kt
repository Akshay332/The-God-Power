package com.goddess.base.views.activities

import android.content.Intent
import com.goddess.base.R
import com.goddess.base.views.fragments.*


class MainActivity : BaseAppCompactActivity() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override val isMakeStatusBarTransparent: Boolean
        get() = false

    override fun init() {

        doFragmentTransaction(fragManager = supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = DevineFragment())
        // check if app is restarted from launcher icon then close redundant activity
        if (!isTaskRoot
                && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
                && intent.action != null
                && intent.action == Intent.ACTION_MAIN) {
            finish()
            return
        }
    }
}
