package com.goddess.base.views.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.goddess.base.views.fragments.ContactsFragment
import com.goddess.base.views.fragments.FriendsFragment
import com.goddess.base.views.fragments.RequestsFragment
import com.goddess.base.views.fragments.SearchFragment

class TopTabspagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            // Created four fragments
            0 -> {
                FriendsFragment()
            }
            1 -> {
                SearchFragment()
            }
            2 -> {
                ContactsFragment()
            }
            else -> {
                RequestsFragment()
            }

        }
    }

    override fun getCount(): Int {
        //return 4 tabs
        return 4

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 ->
                "Friends"

            1 ->
                "Search"

            2 ->
                "Contacts"

            else -> {
                return "Requests"
            }
        }
    }

}