package com.example.starwarscatalog.app.util

import com.example.starwarscatalog.app.model.CharacterModel
import com.example.starwarscatalog.app.model.StarshipModel
import com.example.starwarscatalog.domain.model.CharacterEntity
import com.example.starwarscatalog.domain.model.StarshipEntity

val CharacterEntity.characterModel
    get() = CharacterModel(
        name = name,
        gender = gender,
        starshipsCount = starshipsCount
    )

val CharacterModel.characterEntity
    get() = CharacterEntity(
        name = name,
        gender = gender,
        starshipsCount = starshipsCount
    )

val StarshipEntity.starshipModel
    get() = StarshipModel(
        name = name,
        model = model,
        manufacturer = manufacturer,
        passengers = passengers
    )

val StarshipModel.starshipEntity
    get() = StarshipEntity(
        name = name,
        model = model,
        manufacturer = manufacturer,
        passengers = passengers
    )