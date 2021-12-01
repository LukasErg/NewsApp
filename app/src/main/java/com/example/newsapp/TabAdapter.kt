package com.example.newsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return NewsCategory.Name.values().size
    }

    override fun createFragment(position: Int): Fragment {
        val categoryName: NewsCategory.Name = NewsCategory.Name.values()[position]
        return NewsListFragment.newInstance(categoryName)
    }

}