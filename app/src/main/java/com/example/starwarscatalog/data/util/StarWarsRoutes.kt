package com.example.starwarscatalog.data.util

object StarWarsRoutes {
    private const val BASE_URL = "https://swapi.dev/api"
    const val PEOPLE = "$BASE_URL/people/?search="
    const val STARSHIP = "$BASE_URL/starships/?search="
}