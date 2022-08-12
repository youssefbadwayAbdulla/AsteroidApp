package com.example.myapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.model.DataModel

@Entity(tableName = "data_entity")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val ULid: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "absoluteMagnitude")
    val absoluteMagnitude: Double,
    @ColumnInfo(name = "estimatedDiameterMax")
    val estimatedDiameterMax: Double,
    @ColumnInfo(name = "isPotentiallyHazardousAsteroid")
    val isPotentiallyHazardousAsteroid: Boolean,
    @ColumnInfo(name = "kilometersPerSecond")
    val kilometersPerSecond: String,
    @ColumnInfo(name = "astronomical")
    val astronomical: String
) {
    fun convertToDataModel() = DataModel(
        id = ULid.toString(),
        name,
        date,
        absoluteMagnitude,
        estimatedDiameterMax,
        isPotentiallyHazardousAsteroid,
        kilometersPerSecond,
        astronomical
    )
}