package com.example.starwarscatalog.app.di

import com.example.starwarscatalog.app.ui.screen.favorite.FavoriteViewModel
import com.example.starwarscatalog.app.ui.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { _ ->
        FavoriteViewModel(favoriteRepository = get())
    }
    viewModel { _ ->
        MainViewModel(
            starWarsRepository = get(),
            favoriteRepository = get()
        )
    }
}