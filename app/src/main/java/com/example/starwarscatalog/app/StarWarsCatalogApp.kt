package com.example.starwarscatalog.app

import android.app.Application
import com.example.starwarscatalog.app.di.appModule
import com.example.starwarscatalog.app.di.dataModule
import com.example.starwarscatalog.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StarWarsCatalogApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(androidContext = this@StarWarsCatalogApp)
            modules(
                appModule,
                dataModule,
                domainModule
            )
        }
    }
}