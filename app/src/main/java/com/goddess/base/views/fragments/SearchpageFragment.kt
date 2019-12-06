package com.goddess.base.views.fragments


import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_searchpage.*
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE




/**
 * A simple [Fragment] subclass.
 */
class SearchpageFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_searchpage
    override val viewModel: BaseViewModel?
        get() = null

    override fun init() {
        ivCancel.setOnClickListener { (activity!!.supportFragmentManager.popBackStack()) }
        //hide the status bar
        activity!!.window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_FULLSCREEN


    }
}




