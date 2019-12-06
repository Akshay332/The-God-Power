package com.goddess.base.views.fragments


import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel


/**
 * A simple [Fragment] subclass.
 */
class ResetPasswordFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_reset_password
    override val viewModel: BaseViewModel?
        get() = null
    override fun init() {
        val window = activity!!.window
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        window.setStatusBarColor(ContextCompat.getColor(activity!!,R.color.colorWhite))

    }


}
