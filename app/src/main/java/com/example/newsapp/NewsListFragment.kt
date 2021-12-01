package com.example.newsapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListFragment : Fragment(), Callback<Feed> {

    private lateinit var newsListAdapter: NewsListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    companion object {
        fun newInstance(categoryName: NewsCategory.Name): NewsListFragment {
            val bundle = Bundle()
            bundle.putSerializable("categoryName", categoryName)
            val fragment = NewsListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        fetchNewsList()
    }

    override fun onResume() {
        super.onResume()
        fetchNewsList()
    }

    private fun initViews() {
        swipeRefreshLayout = requireView().findViewById(R.id.swipe_refresh_layout)
        swipeRefreshLayout.setOnRefreshListener { refreshNews() }

        recyclerView = requireView().findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        newsListAdapter = NewsListAdapter()
        recyclerView.adapter = newsListAdapter
    }

    private fun refreshNews()
    {
        fetchNewsList()
        swipeRefreshLayout.isRefreshing = false
    }

    private fun fetchNewsList() {
        val call = getNewsCall()
        call.enqueue(this)
    }

    private fun getNewsCall(): Call<Feed> {

        val mainActivity: MainActivity = activity as MainActivity
        val newsService: NewsService = mainActivity.newsService
        val bundle: Bundle? = arguments

        return when (bundle?.getSerializable("categoryName") as NewsCategory.Name) {
            NewsCategory.Name.TOP_NEWS -> newsService.fetchTopNews()
            NewsCategory.Name.WIRTSCHAFT -> newsService.fetchEconomics()
            NewsCategory.Name.POLITIK -> newsService.fetchPolitics()
            NewsCategory.Name.DIGITALES -> newsService.fetchDigitalNews()
            NewsCategory.Name.SPORT -> newsService.fetchSportNews()
            else -> newsService.fetchScienceNews()
        }
    }

    override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
        if (response.isSuccessful) {
            val feed: Feed? = response.body()
            onFeedReceived(feed)
        } else {
            Log.e("FragmentNews", "onResponse was not successful")
            onError()
        }
    }

    override fun onFailure(call: Call<Feed>, t: Throwable) {
        Log.e("FragmentNews", "onFailure: $t")
        onError()
    }

    private fun onFeedReceived(feed: Feed?) {
        Log.d("FragmentNews", "Feed received: " + feed.toString())
        newsListAdapter.feed = feed
    }

    private fun onError() {
        Log.e("FragmentNews", "Feed request error")
    }
}