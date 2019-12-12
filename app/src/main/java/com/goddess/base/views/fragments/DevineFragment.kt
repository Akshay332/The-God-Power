package com.goddess.base.views.fragments


import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.goddess.base.R
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.activities.BaseAppCompactActivity
import com.goddess.base.views.activities.doFragmentTransaction
import kotlinx.android.synthetic.main.fragment_devine.*

/**
 * A simple [Fragment] subclass.
 */
class DevineFragment : BaseFragment(),View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_devine
    override val viewModel: BaseViewModel?
        get() = null

    override fun init() {
        activity!!.window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorTransparent)
        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          txtv_devine.setOnClickListener(this)
        txtv_next.setOnClickListener(this)
        val zoom = AnimationUtils.loadAnimation(activityContext,R.anim.zoom_in)
        txtv_next.startAnimation(zoom)
        val bounce = AnimationUtils.loadAnimation(activityContext,R.anim.bounce)
        txtv_devine.startAnimation(bounce)
//        signin_GoogleBtn.setOnClickListener(this)
//        signin_FacebookBtn.setOnClickListener(this)
//        txtv_create_account.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.txtv_next ->{
                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = WelcomeDevinePowerFragment(), isAddFragment = false)
            }
//            R.id.signin_GoogleBtn ->{
//                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId =R.id.flFragContainerMain, fragment = BottomNavigationTabLayoutFragment(), isAddFragment = false  )
//            }
//            R.id.signin_FacebookBtn ->{
//                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId =R.id.flFragContainerMain, fragment = BottomNavigationTabLayoutFragment(), isAddFragment = false  )
//            }
//            R.id.txtv_create_account ->{
//                (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId =R.id.flFragContainerMain, fragment = SetupAccountFragment(), isAddFragment = false  )
//            }

        }
    }


}
