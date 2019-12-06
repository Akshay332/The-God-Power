package com.goddess.base.repository.models

data class BlogPostAllPlaces(
        var name: String,
        var loaction: String,
        var friends: String,
        var imgplace: String

) {
    override fun toString(): String {
        return "BlogPostAllPlaces(name='$name',location='$loaction',friends='$friends',image='$imgplace')"
    }
}