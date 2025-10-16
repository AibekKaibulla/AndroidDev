package com.example.sis2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val items: MutableList<NewsCard>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val item = items[position]
        val url = item.imageUrl

        holder.title.text = item.title
        holder.desc.text = item.description

        Glide.with(holder.image.context)
            .load(url)
            .placeholder(android.R.color.darker_gray)
            .error(android.R.color.holo_red_dark)
            .centerCrop()
            .into(holder.image)

        holder.likeButton.text = if (item.isLiked) "Liked" else "Like"
        holder.likeButton.setOnClickListener {
            item.isLiked = !item.isLiked
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.newsImageView)
        val title: TextView = view.findViewById(R.id.newsTextTitle)
        val desc: TextView = view.findViewById(R.id.newsTextDesc)
        val likeButton: Button = view.findViewById(R.id.newsLikeButton)
    }
}
