package com.example.starwarscatalog.data.util

import com.example.starwarscatalog.data.local.model.CharacterFavoriteData
import com.example.starwarscatalog.data.local.model.StarshipFavoriteData
import com.example.starwarscatalog.data.remote.model.CharacterData
import com.example.starwarscatalog.data.remote.model.StarshipData
import com.example.starwarscatalog.domain.model.CharacterEntity
import com.example.starwarscatalog.domain.model.StarshipEntity

val CharacterData.characterEntity
    get() = CharacterEntity(
        name = name,
        gender = gender,
        starshipsCount = starships.count()
    )

val CharacterEntity.characterFavoriteData
    get() = CharacterFavoriteData(
        name = name,
        gender = gender,
        starshipCount = starshipsCount
    )

val CharacterFavoriteData.characterEntity
    get() = CharacterEntity(
        name = name,
        gender = gender,
        starshipsCount = starshipCount
    )

val StarshipData.starshipEntity
    get() = StarshipEntity(
        name = name,
        model = model,
        manufacturer = manufacturer,
        passengers = passengers
    )

val StarshipEntity.starshipFavoriteData
    get() = StarshipFavoriteData(
        name = name,
        model = model,
        manufacturer = manufacturer,
        passengers = passengers
    )

val StarshipFavoriteData.starshipEntity
    get() = StarshipEntity(
        name = name,
        model = model,
        manufacturer = manufacturer,
        passengers = passengers
    )