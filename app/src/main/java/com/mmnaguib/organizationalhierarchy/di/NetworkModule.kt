package com.mmnaguib.organizationalhierarchy.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mmnaguib.organizationalhierarchy.network.ApiService
import com.mmnaguib.organizationalhierarchy.network.NetworkInterceptor
import com.mmnaguib.organizationalhierarchy.utils.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


val networkModule = module {

    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        NetworkInterceptor()
    }

    single {
        OkHttpClient.Builder()
//            .connectTimeout(C.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
//            .readTimeout(C.READ_TIMEOUT, TimeUnit.SECONDS)
//            .writeTimeout(C.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(get<NetworkInterceptor>())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }


}