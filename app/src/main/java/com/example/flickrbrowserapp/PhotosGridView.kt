package com.example.flickrbrowserapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.flickrbrowserapp.Model.Photo
import com.squareup.picasso.Picasso

class PhotosGridView(var context: Context, var photosList: ArrayList<Photo>) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    override fun getCount(): Int = photosList.size

    override fun getItem(p0: Int): Any = photosList[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        if (layoutInflater == null) {
            layoutInflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.row_item, null)
        }

        imageView = convertView!!.findViewById(R.id.imFlicker)
        textView = convertView.findViewById(R.id.tvTitle)
        Picasso.with(context)
                .load(photosList[p0].url_w)
                .resize(170, 170)
                .into(imageView)
        textView.text = photosList[p0].title

        convertView.setOnClickListener {
            val intent = Intent(context, DetailsActivity :: class.java)
            intent.putExtra("image", photosList[p0])
            context.startActivity(intent)
        }

        return convertView
    }

    fun update(list: ArrayList<Photo>) {
        photosList = list
        notifyDataSetChanged()
    }
}