package com.example.myapplication.data.response

import com.example.myapplication.data.entities.DataEntity
import com.example.myapplication.domain.model.DataModel
import com.google.gson.annotations.SerializedName

data class DayResponse(
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitude: Double,
    @SerializedName("close_approach_data")
    val closeApproachData: List<CloseApproachData>,
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,
    @SerializedName("is_sentry_object")
    val isSentryObject: Boolean,
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("nasa_jpl_url")
    val nasaJplUrl: String,
    @SerializedName("neo_reference_id")
    val neoReferenceId: String
) {
    fun convertToDataModel() = DataModel(
        id = id ?: "",
        name = name ?: "",
        date = closeApproachData.firstOrNull()?.close_approach_date ?: "",
        absoluteMagnitude = absoluteMagnitude ?: 0.0,
        estimatedDiameterMax = estimatedDiameter?.kilometers?.estimated_diameter_max ?: 0.0,
        isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid ?: false,
        kilometersPerSecond = closeApproachData.firstOrNull()?.relative_velocity?.kilometers_per_second
            ?: "",
        astronomical = closeApproachData.firstOrNull()?.miss_distance?.astronomical ?: ""
    )
    fun convertToDataEntity()=DataEntity(
        name = name ?: "",
        date = closeApproachData.firstOrNull()?.close_approach_date ?: "",
        absoluteMagnitude = absoluteMagnitude ?: 0.0,
        estimatedDiameterMax = estimatedDiameter?.kilometers?.estimated_diameter_max ?: 0.0,
        isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid ?: false,
        kilometersPerSecond = closeApproachData.firstOrNull()?.relative_velocity?.kilometers_per_second
            ?: "",
        astronomical = closeApproachData.firstOrNull()?.miss_distance?.astronomical ?: ""
    )

}

