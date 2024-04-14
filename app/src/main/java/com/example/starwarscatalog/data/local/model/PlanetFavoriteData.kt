package com.example.starwarscatalog.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planet")
data class PlanetFavoriteData(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "diameter")
    val diameter: String,
    @ColumnInfo(name = "population")
    val population: String
)