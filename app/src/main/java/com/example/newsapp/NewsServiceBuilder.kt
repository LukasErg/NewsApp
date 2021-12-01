package com.example.newsapp

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class NewsServiceBuilder {

    val BASE_URL : String = "https://www.welt.de"

    fun build() : NewsService {
        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(SimpleXmlConverterFactory.create()).build()
        return retrofit.create(NewsService::class.java)
    }
}