package com.example.flickrbrowserapp.Model

import java.io.Serializable

data class Photo(
    val farm: Int,
    val height_w: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    val url_w: String,
    val width_w: Int
)  : Serializable