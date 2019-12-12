package com.goddess.base.views.fragments


import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.activities.BaseAppCompactActivity
import com.goddess.base.views.activities.doFragmentTransaction
import kotlinx.android.synthetic.main.fragment_welcometo_devinepower.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeDevinePowerFragment : BaseFragment(),View.OnClickListener,Animation.AnimationListener {
    override fun onAnimationRepeat(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {

    }

    override fun onAnimationStart(animation: Animation?) {

    }


    override val layoutId: Int
        get() = R.layout.fragment_welcometo_devinepower
    override val viewModel: BaseViewModel?
        get() = null

    override fun init() {
        val txt = SpannableString(getString(R.string.welcome_to_devine))
        val txt2 = getString(R.string.devine_power)
        val index = txt.toString().indexOf(txt2, ignoreCase = true)
        val indexend = index + txt2.length
        txt.setSpan(ForegroundColorSpan(ContextCompat.getColor(activity!!, R.color.colorMaroon)), index, indexend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        txtv_welcmTrouvle.setText(txt, TextView.BufferType.SPANNABLE)

        val window = activity!!.window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(activity!!, R.color.colorWhite)

        iv_backbtn.setOnClickListener {(activity!!.supportFragmentManager.popBackStack()) }

        Glide.with(this)
                .load("https://images-na.ssl-images-amazon.com/images/I/71%2BATmtoucL._SL1200_.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_hnuman)
        Glide.with(this)
                .load("https://www.thestatesman.com/wp-content/uploads/2019/08/ganesh.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_gnesh)
        Glide.with(this)
                .load("https://www.templepurohit.com/wp-content/uploads/2015/11/27-e1459207878731-1453x1600.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_shiva)
        Glide.with(this)
                .load("https://new-img.patrika.com/upload/2018/06/01/shanivar1_2887444_835x547-m.jpg")
                .placeholder(R.drawable.ic_avatar)
                .into(iv_shani)

        iv_hnuman.setOnClickListener(this)
        iv_gnesh.setOnClickListener(this)
        iv_shiva.setOnClickListener(this)
        iv_shani.setOnClickListener(this)
        txtv_welcmTrouvle.setOnClickListener(this)
        txtv_choice.setOnClickListener(this)

        val bounce = AnimationUtils.loadAnimation(activityContext,R.anim.bounce)
        txtv_welcmTrouvle.startAnimation(bounce)
        val blink = AnimationUtils.loadAnimation(activityContext,R.anim.blink)
        txtv_choice.startAnimation(blink)





    }


    override fun onClick(p0: View?) {

        when(p0!!.id) {
            R.id.iv_hnuman -> {
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = HanumanChalisaFragment(), isAddFragment = false)

            }
            R.id.iv_gnesh ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = GaneshChalisaFragment(), isAddFragment = false)

            }
            R.id.iv_shiva ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = ShivChalisaFragment(), isAddFragment = false)

            }
            R.id.iv_shani ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = ShaniChalisaFragment(), isAddFragment = false)
            }


        }
    }
}
