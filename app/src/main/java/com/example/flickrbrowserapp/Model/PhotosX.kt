package com.example.flickrbrowserapp.Model

data class PhotosX(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: ArrayList<Photo>,
    val total: Int
)