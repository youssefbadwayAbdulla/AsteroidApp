package com.example.myapplication.data.response

import com.google.gson.annotations.SerializedName

data class GetAPIResponse(
    @SerializedName("links")
    var links: Links? = null,
    @SerializedName("element_count")
    var elementCount:Int?=null,
    @SerializedName("near_earth_objects")
    var nearEarthObject:Map<String,MutableList<DayResponse>>?=null
)
