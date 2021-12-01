package com.example.newsapp

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "enclosure", strict = false)
class Image @JvmOverloads constructor(
    @field:Attribute(name="url")
    @param:Attribute(name="url")
    var url : String = ""
)