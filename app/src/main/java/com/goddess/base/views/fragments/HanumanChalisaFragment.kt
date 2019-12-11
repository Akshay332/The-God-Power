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
import kotlinx.android.synthetic.main.fragment_hanuman.*


/**
 * A simple [Fragment] subclass.
 */
class HanumanChalisaFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_hanuman
    override val viewModel: BaseViewModel?
        get() = null
    override fun init() {
        iv_backBtn.setOnClickListener { (activity!!.supportFragmentManager.popBackStack()) }
        Glide.with(this)
                .load("https://www.bhaktiphotos.com/wp-content/uploads/2018/04/Lord-Hanuman-Ji-Ramayan-Photos.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_hnumanimg)
    }

}



