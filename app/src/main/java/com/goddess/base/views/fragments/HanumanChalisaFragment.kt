package com.goddess.base.views.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel


/**
 * A simple [Fragment] subclass.
 */
class HanumanChalisaFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_hanuman
    override val viewModel: BaseViewModel?
        get() = null
    override fun init() {

    }

}



