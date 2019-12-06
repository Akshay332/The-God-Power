package com.goddess.base.repository.models

class DataSourceLocations {
    companion object {
        fun createdata(): ArrayList<BlogPostLocations> {
            val list = ArrayList<BlogPostLocations>()
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            list.add(BlogPostLocations("Paris,France", "Museums")
            )
            return list
        }
    }
}