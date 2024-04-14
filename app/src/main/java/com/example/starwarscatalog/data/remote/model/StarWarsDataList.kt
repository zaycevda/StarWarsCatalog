package com.example.starwarscatalog.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarWarsDataList<T>(@SerialName(value = "results") val results: List<T>) {
    companion object {
        fun <T> empty() = StarWarsDataList<T>(
            results = emptyList()
        )
    }
}