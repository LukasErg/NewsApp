package com.example.newsapp

class NewsCategory {

    enum class Name {
        TOP_NEWS, POLITIK, WIRTSCHAFT, DIGITALES, WISSENSCHAFT, SPORT;

        fun getName(): String {
            return when (this) {
                TOP_NEWS -> "Trends"
                else
                -> this.name
            }
        }
    }
}