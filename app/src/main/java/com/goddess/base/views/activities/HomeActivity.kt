package com.goddess.base.views.activities

import com.goddess.base.R

class HomeActivity : BaseAppCompactActivity() {

    override val layoutId: Int
        get() = R.layout.activity_home

    override val isMakeStatusBarTransparent: Boolean
        get() = true

    override fun init() {
    }

}