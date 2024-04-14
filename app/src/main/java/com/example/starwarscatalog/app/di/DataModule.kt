package com.example.starwarscatalog.app.di

import androidx.room.Room
import com.example.starwarscatalog.data.local.database.StarWarsCatalogDatabase
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataModule = module {
    single { _ ->
        HttpClient(engineFactory = Android) {
            install(plugin = ContentNegotiation) {
                json(
                    json = Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    single { _ ->
        Room
            .databaseBuilder(
                context = get(),
                klass = StarWarsCatalogDatabase::class.java,
                name = "star_wars_catalog.database"
            )
            .build()
    }
}