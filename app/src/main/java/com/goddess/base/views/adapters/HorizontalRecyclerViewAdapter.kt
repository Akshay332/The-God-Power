package com.goddess.base.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.goddess.base.R
import com.goddess.base.repository.models.BlogPostLocations
import kotlinx.android.synthetic.main.row_loactions.view.*

class HorizontalRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<BlogPostLocations> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogviewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_loactions, parent, false)

        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BlogviewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPostLocations>) {
        items = blogList
        notifyDataSetChanged()
    }

    class BlogviewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val blog_location = itemView.txTv_location_paris
        val blog_location2 = itemView.txTvmuseum
        fun bind(blogPostLocations: BlogPostLocations) {
            blog_location.setText(blogPostLocations.loction1)
            blog_location2.setText(blogPostLocations.location2)

        }
    }


}