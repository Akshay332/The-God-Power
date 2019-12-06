package com.goddess.base.views.fragments


import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.activities.BaseAppCompactActivity
import com.goddess.base.views.activities.doFragmentTransaction
import kotlinx.android.synthetic.main.fragment_setup_account.*

/**
 * A simple [Fragment] subclass.
 */
class SetupAccountFragment : BaseFragment(),View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_setup_account
    override val viewModel: BaseViewModel?
        get() = null
    override fun init() {
        val txt = SpannableString(getString(R.string.setup_account))
        val txt2 = getString(R.string.account)
        val index = txt.toString().indexOf(txt2, ignoreCase = true)
        val indexend = index + txt2.length
        txt.setSpan(ForegroundColorSpan(ContextCompat.getColor(activity!!, R.color.colorMaroon)), index, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        txtv_setupAccount.setText(txt, TextView.BufferType.SPANNABLE)
        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity!!.window.statusBarColor = ContextCompat.getColor(activity!!, R.color.colorWhite)
        iv_backBtn.setOnClickListener(this)
        txtv_next.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.iv_backBtn ->{
                (activity!!.supportFragmentManager.popBackStack())
            }
            R.id.txtv_next ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = WelcomeTrouvailleFragment(), isAddFragment = false)
            }
        }
    }


}
