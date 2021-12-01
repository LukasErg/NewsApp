package com.example.newsapp

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class Feed @JvmOverloads constructor (

    @field:Element (name = "channel")
    @param:Element(name = "channel")
    var channel : Channel? = null
)
