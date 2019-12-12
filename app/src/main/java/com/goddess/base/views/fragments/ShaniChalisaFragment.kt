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
import kotlinx.android.synthetic.main.fragment_shani_dev.*
import kotlinx.android.synthetic.main.fragment_shiv_chalisa.*
import kotlinx.android.synthetic.main.fragment_welcometo_devinepower.*

/**
 * A simple [Fragment] subclass.
 */
class ShaniChalisaFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_shani_dev
    override val viewModel: BaseViewModel?
        get() = null
    override fun init() {
        iv_backBtn.setOnClickListener{(activity!!.supportFragmentManager.popBackStack())}
        activity!!.window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorTransparent)
        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        Glide.with(this)
                .load("https://timesofindia.indiatimes.com/thumb/msid-67384507,imgsize-1020980,width-800,height-600,resizemode-4/67384507.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_shaniimg)
        val animationDrawable = layout.getBackground() as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }


}
