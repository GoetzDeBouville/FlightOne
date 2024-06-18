package com.starbars.search.di

import android.content.Context
import android.content.SharedPreferences
import com.starbars.search.data.api.ApiService
import com.starbars.search.data.api.SearchRemoteDataSource
import com.starbars.search.data.impl.SearchMockDataSource
import com.starbars.search.data.impl.SearchRemoteDataSourceImpl
import com.starbars.search.data.prefs.LastPlaceStorage
import com.starbars.search.data.prefs.LastPlaceStorageImpl
import com.starbars.search.data.repository.FlightDetailsRepositoryImpl
import com.starbars.search.data.repository.SearchRepositoryImpl
import com.starbars.search.data.repository.SharedSearchStateRepositoryImpl
import com.starbars.search.data.repository.TicketsRepositoryImpl
import com.starbars.search.domain.api.FlightDetailsRepository
import com.starbars.search.domain.api.SearchRepository
import com.starbars.search.domain.api.SharedSearchStateRepository
import com.starbars.search.domain.api.TicketsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal val dataModule = module {
    singleOf(::SearchRepositoryImpl) { bind<SearchRepository>() }
    singleOf(::SearchRemoteDataSourceImpl) { bind<SearchRemoteDataSource>() }
    singleOf(::SearchMockDataSource)
    singleOf(::LastPlaceStorageImpl) { bind<LastPlaceStorage>() }
    singleOf(::FlightDetailsRepositoryImpl) { bind<FlightDetailsRepository>() }
    singleOf(::TicketsRepositoryImpl) { bind<TicketsRepository>() }
    singleOf(::SharedSearchStateRepositoryImpl) { bind<SharedSearchStateRepository>() }

    single<ApiService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<SharedPreferences> {
        androidContext().getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    }
}

private const val BASE_URL = "https://drive.google.com/"
private const val PREFS_KEY = "key_prefs"