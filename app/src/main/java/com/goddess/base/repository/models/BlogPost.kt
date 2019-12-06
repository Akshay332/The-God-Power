package com.codingwithmitch.kotlinrecyclerviewexample.models

data class BlogPost(

        var title: String,

        var idname: String,

        var loaction: String,

        var profile: String


) {

    override fun toString(): String {
        return "BlogPost(title='$title',id='$idname', location='$loaction',profile='$profile')"
    }


}
























