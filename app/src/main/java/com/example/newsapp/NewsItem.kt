package com.example.newsapp

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name ="item", strict = false)
class NewsItem @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "link")
    @param:Element(name = "link")
    var link: String? = null,

    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String? = null,

    @field:Element(name = "category")
    @param:Element(name = "category")
    var category: String? = null,

    @field:Element(name = "pubDate")
    @param:Element(name = "pubDate")
    var publishTime: String? = null,

    @field:Element(name = "author", required = false)
    @param:Element(name = "author", required = false)
    var author: String? = null,

    @field:Element(name="enclosure")
    @param:Element(name="enclosure")
    var image: Image? = null
)