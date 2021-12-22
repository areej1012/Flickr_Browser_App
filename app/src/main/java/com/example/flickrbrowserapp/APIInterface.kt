package com.example.flickrbrowserapp


import com.example.flickrbrowserapp.Model.Photo
import com.example.flickrbrowserapp.Model.Photos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    //https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=1ae6d33017f66d5276fddbba63a5acd2&format=json&nojsoncallback=1&text=cat&extras=url_h

    @GET("rest/?")
    fun getSearchPhotos(@Query("method") method : String,@Query("api_key") api_key : String,
                        @Query("format") format : String,@Query("nojsoncallback") nojsoncallback : String,
                        @Query("tags") text : String,@Query("extras") extras : String,) : Call<Photos>
}