package com.example.starwarscatalog.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarshipData(
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "model")
    val model: String,
    @SerialName(value = "manufacturer")
    val manufacturer: String,
    @SerialName(value = "passengers")
    val passengers: String
)