package com.example.myapplication.presentation.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.myapplication.R

fun ImageView.downloadImage(url:String){
    Glide.with(context)
        .load(Uri.parse(url))
        .centerCrop()
        .placeholder(R.drawable.placeholder_photo)
        .into(this)
}