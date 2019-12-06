package com.goddess.base.views.fragments


import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.activities.BaseAppCompactActivity
import com.goddess.base.views.activities.doFragmentTransaction
import kotlinx.android.synthetic.main.fragment_welcometo_trouvaille.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeTrouvailleFragment : BaseFragment(),View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_welcometo_trouvaille
    override val viewModel: BaseViewModel?
        get() = null

    override fun init() {
        val txt = SpannableString(getString(R.string.welcome_to_trouvaille))
        val txt2 = getString(R.string.trouvaille)
        val index = txt.toString().indexOf(txt2, ignoreCase = true)
        val indexend = index + txt2.length
        txt.setSpan(ForegroundColorSpan(ContextCompat.getColor(activity!!, R.color.colorMaroon)), index, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        txtv_welcmTrouvle.setText(txt, TextView.BufferType.SPANNABLE)

        val window = activity!!.window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(activity!!, R.color.colorWhite)

        signinBtn.setOnClickListener(this)
        txtv_create_account.setOnClickListener(this)
        txtv_forgot_paswrd.setOnClickListener(this)
        iv_backbtn.setOnClickListener(this)





    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.signinBtn ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager,containerViewId = R.id.flFragContainerMain, fragment = BottomNavigationTabLayoutFragment(), isAddFragment = false)
            }
            R.id.txtv_create_account ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = SetupAccountFragment(), isAddFragment = false)
            }
            R.id.txtv_forgot_paswrd ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = ResetPasswordFragment(), isAddFragment = false)
            }
            R.id.iv_backbtn ->{
                (activity!!.supportFragmentManager.popBackStack())
            }
        }
    }


}
