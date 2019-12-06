package com.goddess.base.views.fragments


import android.graphics.Color
import android.view.View
import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.repository.models.Tab
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_bottom_navigation_tab_layout.*

/**
 * A simple [Fragment] subclass.
 */
class BottomNavigationTabLayoutFragment : BaseTabLayoutFragment() {
    override fun initTabs() {

        val bottomtabs = mutableListOf<Tab>()
        bottomtabs.add(Tab(ExploreFragment(), "Explore", R.drawable.drawable_ic_explore_selector, true))
        bottomtabs.add(Tab(ConnectWithFriendTabLayoutFragment(), "Social", R.drawable.drawable_ic_social_selector, true))
        bottomtabs.add(Tab(NotificationFragment(), "Notification", R.drawable.drawable_ic_notification_selector, true))
        bottomtabs.add(Tab(ProfileFragment(), "Profile", R.drawable.drawable_ic_profile_selector, true))
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#C85050"))

        val window = activity!!.window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        setViewPager("", bottomtabs)


        // set icons for tabs
        for (i in 0 until tabLayout.tabCount) {

            tabLayout.getTabAt(i)!!.setIcon(bottomtabs[i].tabIcon)

        }

    }

    override val layoutId: Int
        get() = R.layout.fragment_bottom_navigation_tab_layout

    override val viewModel: BaseViewModel?
        get() = null


}
