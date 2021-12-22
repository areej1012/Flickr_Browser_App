package com.example.flickrbrowserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.flickrbrowserapp.Model.Photo
import com.example.flickrbrowserapp.Model.Photos
import com.example.flickrbrowserapp.databinding.ActivitySearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    //https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=1ae6d33017f66d5276fddbba63a5acd2&format=json&nojsoncallback=1&text=3&extras=url_h
    lateinit var binding: ActivitySearchBinding
    val method =  "flickr.photos.search"
    val api_key = "1ae6d33017f66d5276fddbba63a5acd2"
    val format ="json"
    val extras = "url_w"
    lateinit var listPhotos : ArrayList<Photo>
    lateinit var adpter : PhotosGridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        listPhotos = ArrayList()
        adpter = PhotosGridView(this, listPhotos)
        binding.gv.adapter = adpter

        val textSearch = intent.extras!!.getString("textSearch")

        requstAPI(textSearch)
    }

    private fun requstAPI(textSearch: String?) {
        val apiInterface = APIClient().getImage()?.create(APIInterface :: class.java)
        apiInterface?.getSearchPhotos(method,api_key ,format,"1",textSearch!!,extras)?.enqueue(object : Callback<Photos>{

            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
              try {
                  listPhotos = response.body()!!.photos.photo
                  adpter.update(listPhotos)

              }catch (e : Exception){
                  Log.e("CATCH", e.localizedMessage)
              }
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                Log.e("SEARCH_MAIN", t.localizedMessage)
            }

        })
    }



}