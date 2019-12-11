package com.goddess.base.views.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide

import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_ganesh.*

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
        Glide.with(this)
                .load("https://pujavidhi.in/wp-content/uploads/2019/05/Ganesh-Chalisa.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_gneshimg)
    }


}
