package com.mmnaguib.organizationalhierarchy

import android.app.Application
import androidx.databinding.library.BuildConfig
import com.mmnaguib.organizationalhierarchy.di.networkModule
import com.mmnaguib.organizationalhierarchy.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.android.*
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(viewModelsModule)
            modules(networkModule)
        }
    }
}