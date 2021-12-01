package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("/feeds/topnews.rss")
    fun fetchTopNews() : Call<Feed>

    @GET("/feeds/section/politik.rss")
    fun fetchPolitics() : Call<Feed>

    @GET("/feeds/section/wirtschaft.rss")
    fun fetchEconomics() : Call<Feed>

    @GET("/feeds/section/wirtschaft/webwelt.rss")
    fun fetchDigitalNews() : Call<Feed>

    @GET("/feeds/section/wissenschaft.rss")
    fun fetchScienceNews() : Call<Feed>

    @GET("/feeds/section/sport.rss")
    fun fetchSportNews() : Call<Feed>
}