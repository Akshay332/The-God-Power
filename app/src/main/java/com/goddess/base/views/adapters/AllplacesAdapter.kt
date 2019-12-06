package com.goddess.base.views.adapters

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.goddess.base.R
import com.goddess.base.repository.models.BlogPostAllPlaces
import com.goddess.base.views.activities.BaseAppCompactActivity
import com.goddess.base.views.activities.doFragmentTransaction
import com.goddess.base.views.fragments.ArcdeTriompheFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_all_placeslist.view.*


class AllplacesAdapter(val mFragment: Fragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<BlogPostAllPlaces> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return Blogviewholder(

                LayoutInflater.from(parent.context).inflate(R.layout.row_all_placeslist, parent, false)
        )


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Blogviewholder -> {
                holder.bind(items.get(position))
//                if (position==0){
//                    Log.d(TAG, "clicked")
//                }


            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPostAllPlaces>) {
        items = blogList
        notifyDataSetChanged()
    }

    inner class Blogviewholder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val blog_imag = itemView.iv_image_places
        val blog_name = itemView.txTv_triomphe
        val blog_location = itemView.txTvLocation
        val blog_friendsvisited = itemView.txTv_two_friends


        init {

            itemView.setOnClickListener(View.OnClickListener {
                Toast.makeText(itemView.context, "Clicked Card...", Toast.LENGTH_LONG).show()
                (mFragment.activity as BaseAppCompactActivity).doFragmentTransaction(fragManager = mFragment.activity!!.supportFragmentManager, containerViewId = R.id.flFragContainerMain, fragment = ArcdeTriompheFragment(), isAddFragment = false)

            })

        }

        fun bind(blogPostAllPlaces: BlogPostAllPlaces) {
            blog_name.setText(blogPostAllPlaces.name)
            blog_name.setOnClickListener {
                Log.d(TAG, "clicked")
            }
            blog_location.setText(blogPostAllPlaces.loaction)
            blog_friendsvisited.setText(blogPostAllPlaces.friends)

            Glide.with(itemView.context)
                    .load(blogPostAllPlaces.imgplace)
                    .placeholder(R.drawable.ic_profile)
                    .into(blog_imag)

        }
    }

}