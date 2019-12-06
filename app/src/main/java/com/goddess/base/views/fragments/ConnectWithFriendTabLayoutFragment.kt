package com.goddess.base.views.fragments


import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.goddess.base.R
import com.goddess.base.repository.models.Tab
import com.goddess.base.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_base_tab_layout.*

/**
 * A simple [Fragment] subclass.
 */
class ConnectWithFriendTabLayoutFragment : BaseTabLayoutFragment() {

    override fun initTabs() {
        val toptabs = mutableListOf<Tab>()
        toptabs.add(Tab(FriendsFragment(), "Friends", R.drawable.drawable_ic_friends_selector, true))
        toptabs.add(Tab(SearchFragment(), "Search", R.drawable.drawable_ic_search_selector, true))
        toptabs.add(Tab(ContactsFragment(), "Contacts", R.drawable.drawable_ic_contacts_selector, true))
        toptabs.add(Tab(RequestsFragment(), "Requests", R.drawable.drawable_ic_requests_selector, true))

        setViewPager("Connect with Friends", toptabs)


        appBarLayout.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.colorMaroon))
        // set icons for tabs
        for (i in 0 until tabLayout.tabCount) {
            tabLayout.getTabAt(i)!!.setIcon(toptabs[i].tabIcon)
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_base_tab_layout

    override val viewModel: BaseViewModel?
        get() = null

    //
    //override fun init() {

//       //set the text of the toolbarTitle
//
//
//        //set the color of the text in  title of the toolbar
//        tvTitle.setTextColor(resources.getColor(R.color.colorWhite))
//        //set the textSize of toolbar
//        tvTitle.textSize = 17f
//        //set the color of appbar layout color
//        appBarLayout.setBackgroundColor(resources.getColor(R.color.maroon))
//
//        val topTabspagerAdapter = TopTabspagerAdapter(activity!!.supportFragmentManager)
//        viewPager.adapter =topTabspagerAdapter
//        //setup the ViewPager
//        tabLayout.setupWithViewPager(viewPager)
//        //set the icon of the tabs
//        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_friends_selected)
//        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_searchwhite)
//        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_contact)
//        tabLayout.getTabAt(3)!!.setIcon(R.drawable.ic_request)
//
//
//
//    }
//

    // }
}
