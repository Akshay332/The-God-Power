package com.goddess.base.views.fragments

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.goddess.base.R
import com.goddess.base.utils.MyCustomLoader
import com.goddess.base.viewmodels.BaseViewModel
import com.goddess.base.views.activities.MainActivity
import com.goddess.base.views.activities.inflate
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by ShrayChona on 03-10-2018.
 * @description extend this class for basic fragment setup
 */
abstract class BaseFragment : androidx.fragment.app.Fragment() {

    private val mMyCustomLoader: MyCustomLoader by lazy { MyCustomLoader(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            container?.inflate(layoutRes = layoutId)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (null != toolbar) {
            toolbar.setNavigationIcon(null)
            toolbar.setNavigationOnClickListener {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
        init()
        observeBaseProperties()
    }

    val activityContext: Context
        get() = activity!!

    /**
     *  @description call this method to show toast or snack bars
     *  @param message {String} String message to be shown (if null method will use resId to show text)
     *  @param resId {Int?} resource id is string (will be used if message value is null)
     *  @param isShowSnackbarMessage {Boolean} A boolean to switch between snackBar and toast
     */
    fun showMessage(resId: Int? = null, message: String? = null, isShowSnackbarMessage: Boolean = false) {
        if (isShowSnackbarMessage) {
            mMyCustomLoader.showSnackBar(view, message ?: getString(resId!!))
        } else {
            mMyCustomLoader.showToast(message ?: getString(resId!!))
        }
    }

    /**
     *  @description call this method to show progress dialog
     *  @param isShowProgress {Boolean} Boolean to show or hide progress bar
     */
    fun showProgressDialog(isShowProgress: Boolean) {
        if (isShowProgress) {
            mMyCustomLoader.showProgressDialog()
        } else {
            mMyCustomLoader.dismissProgressDialog()
        }
    }

    /**
     *  @description call this method to hide progress dialog
     */
    fun dismissDialogFragment() {
        ( activity!!.supportFragmentManager.findFragmentByTag(getString(R.string.dialog)) as androidx.fragment.app.DialogFragment).dismiss()
    }

    /**
     *  @description call this method to start home activity and finish current activity
     */
    protected fun navigateToMainActivity() {
        startActivity(Intent(activityContext, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        activity?.finish()
    }

    /**
     *  @description observe live data values
     */
    private fun observeBaseProperties() {
        //observe session id
        viewModel?.isSessionExpired()?.observe(this, Observer {
            AsyncTask.execute {
                //                FirebaseInstanceId.getInstance().deleteInstanceId()
            }
            if (it!!) navigateToMainActivity()
        })
        // Observer Errors
        viewModel?.getErrorHandler()?.observe(this, Observer {
            showMessage(resId = it?.getErrorResource())
        })

        // Observe Loader
        viewModel?.isShowLoader()?.observe(this, Observer {
            showProgressDialog(it!!)
        })

        // Observe Retrofit Errors
        viewModel?.getMessage()?.observe(this, Observer {
            showMessage(it?.resId, it?.message)
        })
    }

    abstract val layoutId: Int

    abstract val viewModel: BaseViewModel?

//    abstract val isNavigationBarEnabled: Boolean
//
//    abstract val isMakeStatusBarTransparent: Boolean

    abstract fun init()

}