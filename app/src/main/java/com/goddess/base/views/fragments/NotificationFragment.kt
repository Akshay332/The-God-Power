package com.goddess.base.views.fragments


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.goddess.base.R
import com.goddess.base.repository.models.DataSourceNotification
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.adapters.NotificationListAdapter
import kotlinx.android.synthetic.main.toolbar.*

/**
 * A simple [Fragment] subclass.
 */
class NotificationFragment : BaseRecyclerViewFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_notification
    override val viewModel: BaseViewModel?
        get() = null

    override fun setData() {

        tvToolbarTitle.setText(R.string.Notification)

        val data = DataSourceNotification.createData()
        notificationListAdapter.submitList(data)
    }

    private val notificationListAdapter = NotificationListAdapter()

    override val recyclerViewAdapter: RecyclerView.Adapter<*>?
        get() = notificationListAdapter
    override val layoutManager: RecyclerView.LayoutManager?
        get() = null
    override val isShowRecyclerViewDivider: Boolean
        get() = true

    override fun onPullDownToRefresh() {

    }


}

