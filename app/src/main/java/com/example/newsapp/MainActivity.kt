package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityMainBinding
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {


    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    var newsService : NewsService = NewsServiceBuilder().build()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F
        initViews()
    }

    private fun initViews()
    {
        tabLayout = binding.tabLayout
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        viewPager = binding.viewPager
        viewPager.adapter = TabAdapter(this)
        val mediator = TabLayoutMediator(tabLayout, viewPager) { tab, position -> tab.text = NewsCategory.Name.values()[position].getName()}
        mediator.attach()
    }


}