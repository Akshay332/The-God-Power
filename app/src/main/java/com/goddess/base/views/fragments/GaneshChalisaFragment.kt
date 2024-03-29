package com.goddess.base.views.fragments


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_ganesh.*
import kotlinx.android.synthetic.main.fragment_ganesh.iv_backBtn
import kotlinx.android.synthetic.main.fragment_ganesh.layout
import kotlinx.android.synthetic.main.fragment_hanuman.*

/**
 * A simple [Fragment] subclass.
 */
class GaneshChalisaFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_ganesh
    override val viewModel: BaseViewModel?
        get() = null
    override fun init() {
        iv_backBtn.setOnClickListener {  (activity!!.supportFragmentManager.popBackStack()) }
        activity!!.window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorTransparent)
        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        Glide.with(this)
                .load("https://pujavidhi.in/wp-content/uploads/2019/05/Ganesh-Chalisa.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_gneshimg)
        val animationDrawable = layout.getBackground() as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }


}
