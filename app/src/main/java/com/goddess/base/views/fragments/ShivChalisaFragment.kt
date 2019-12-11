package com.goddess.base.views.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
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
        Glide.with(this)
                .load("https://spiderimg.amarujala.com/assets/images/2018/02/13/750x506/shivratri_1518533465.jpeg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_shivimg)
    }


}
