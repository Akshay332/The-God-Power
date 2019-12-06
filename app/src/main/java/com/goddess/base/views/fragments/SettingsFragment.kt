package com.goddess.base.views.fragments


import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_notification.*

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_settings
    override val viewModel: BaseViewModel?
        get() = null

    override fun init() {
       tvToolbarTitle.setText(R.string.settings)
    }


}
