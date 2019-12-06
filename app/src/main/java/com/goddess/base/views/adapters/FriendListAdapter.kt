package com.goddess.base.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goddess.base.R
import com.bumptech.glide.Glide
import com.codingwithmitch.kotlinrecyclerviewexample.models.BlogPost
import kotlinx.android.synthetic.main.row_friendslist.view.*

class FriendListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<BlogPost> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_friendslist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPost>) {
        items = blogList
        notifyDataSetChanged()
    }

    class BlogViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val blog_title = itemView.txtTvTitle
        val blog_id = itemView.txTvsubTitle
        val blog_image = itemView.iv_Friendsimage
        val blog_location = itemView.txTvlocation
        fun bind(blogPost: BlogPost) {
            blog_title.setText(blogPost.title)
            blog_id.setText(blogPost.idname)
            blog_location.setText(blogPost.loaction)
            Glide.with(itemView.context)
                    .load(blogPost.profile)
                    .placeholder(R.drawable.ic_profile)
                    .into(blog_image)


        }
    }
}