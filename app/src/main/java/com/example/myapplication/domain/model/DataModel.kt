package com.example.myapplication.domain.model

import java.io.Serializable

data class DataModel (
    var id:String,
    var name:String,
    var date:String,
    val absoluteMagnitude: Double,
    val estimatedDiameterMax: Double,
    val isPotentiallyHazardousAsteroid: Boolean,
    val kilometersPerSecond: String,
    val astronomical: String
        ):Serializable