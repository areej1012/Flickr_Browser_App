package com.example.flickrbrowserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import com.example.flickrbrowserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, keyEvent ->
            val textSearch = binding.etSearch.text.toString().trim()

            if(keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                if(textSearch.isNotEmpty()){
                    val intent = Intent(this, SearchActivity :: class.java)
                    intent.putExtra("textSearch",textSearch)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Please write something", Toast.LENGTH_LONG).show()
                }
                return@OnKeyListener true
            }
            return@OnKeyListener false
        })


    }


}