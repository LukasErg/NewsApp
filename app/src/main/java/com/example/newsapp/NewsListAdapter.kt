package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsListAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    var feed: Feed? = null

        set(value)
        {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_cell, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem: NewsItem = feed?.channel?.newsList!![position]
        holder.titleTextView?.text = newsItem.title
        holder.teaserTextView?.text = newsItem.description
        Picasso.get().load(newsItem.image?.url).into(holder.imageView)
        holder.itemView.setOnClickListener { view -> onNewsClick(view.context, newsItem) }
    }

    private fun onNewsClick(context: Context, newsItem : NewsItem)
    {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(newsItem.link)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return if (feed != null) feed?.channel?.newsList?.size!! else 0
    }
}