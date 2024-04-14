package com.example.starwarscatalog.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterData(
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "gender")
    val gender: String,
    @SerialName(value = "starships")
    val starships: List<String>
)