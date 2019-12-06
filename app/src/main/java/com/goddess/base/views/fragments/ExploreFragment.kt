package com.goddess.base.views.fragments


import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.repository.models.Tab
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.activities.BaseAppCompactActivity
import com.goddess.base.views.activities.doFragmentTransaction
import kotlinx.android.synthetic.main.fragment_base_tab_layout.*

/**
 * A simple [Fragment] subclass.
 */
class ExploreFragment : BaseTabLayoutFragment() {
    override fun initTabs() {
        val tablist = mutableListOf<Tab>()
        tablist.add(Tab(AllPlacesFragment(),"All palces",R.drawable.drawable_color_allplace_selector,true))
        tablist.add(Tab(VisitedbyFriendsFragment(),"Visited by Friends",R.drawable.drawable_color_allplace_selector,true))
        //val window = activity!!.window
        // change the color of statusBar
        activity!!.window.statusBarColor = ContextCompat.getColor(activity!!, R.color.colorMaroon)
        appBarLayout.setBackgroundColor(ContextCompat.getColor(activity!!,R.color.colorMaroon))
        ivToolbarActionEnd.setImageResource(R.drawable.ic_searchwhite)
        ivToolbarActionEnd.visibility = (view!!.visibility)
        ivToolbarActionEnd.setOnClickListener { (activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = SearchpageFragment(), isAddFragment = false) }
        setViewPager("Explore",tablist)
        tabLayout.tabTextColors = ContextCompat.getColorStateList(activity!!,R.color.colorWhite)

    }

    override val layoutId: Int
        get() = R.layout.fragment_base_tab_layout
    override val viewModel: BaseViewModel?
        get() = null




}
