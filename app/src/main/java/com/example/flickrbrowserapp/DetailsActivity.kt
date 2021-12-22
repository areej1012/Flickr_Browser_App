package com.example.flickrbrowserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.example.flickrbrowserapp.Model.Photo
import com.example.flickrbrowserapp.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val photo = intent.extras!!.getSerializable("image") as Photo

        Picasso.with(this)
            .load(photo.url_w)
            .into(binding.imV)
        binding.tvTitle.text  = photo.title
    }
}