package com.example.newsapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView : ImageView? = null
    var titleTextView : TextView? = null
    var teaserTextView: TextView? = null

    init {
        imageView = itemView.findViewById(R.id.image)
        titleTextView = itemView.findViewById(R.id.title)
        teaserTextView = itemView.findViewById(R.id.teaser)
    }




}