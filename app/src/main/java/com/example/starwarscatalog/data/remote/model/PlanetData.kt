package com.example.starwarscatalog.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetData(
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "diameter")
    val diameter: String,
    @SerialName(value = "population")
    val population: String
)