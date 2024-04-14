package com.example.starwarscatalog.app.di

import com.example.starwarscatalog.data.local.repository.FavoriteRepositoryImpl
import com.example.starwarscatalog.data.remote.repository.StarWarsRepositoryImpl
import com.example.starwarscatalog.domain.repository.FavoriteRepository
import com.example.starwarscatalog.domain.repository.StarWarsRepository
import org.koin.dsl.module

val domainModule = module {
    single<FavoriteRepository> { _ ->
        FavoriteRepositoryImpl(starWarsCatalogDatabase = get())
    }
    single<StarWarsRepository> { _ ->
        StarWarsRepositoryImpl(httpClient = get())
    }
}