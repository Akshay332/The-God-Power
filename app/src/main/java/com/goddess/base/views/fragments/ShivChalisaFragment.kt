package com.goddess.base.views.fragments


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_hanuman.*
import kotlinx.android.synthetic.main.fragment_shiv_chalisa.*


/**
 * A simple [Fragment] subclass.
 */
class ShivChalisaFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_shiv_chalisa
    override val viewModel: BaseViewModel?
        get() = null

    override fun init() {
        iv_backbtn.setOnClickListener { (activity!!.supportFragmentManager.popBackStack()) }
        activity!!.window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorTransparent)
        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        Glide.with(this)
                .load("https://spiderimg.amarujala.com/assets/images/2018/02/13/750x506/shivratri_1518533465.jpeg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_shivimg)
        val animationDrawable = frameLayout.getBackground() as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }


}
