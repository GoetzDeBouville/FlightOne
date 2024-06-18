package com.starbars.search.di

import org.koin.dsl.module


val searchFeatureModule = module {
    includes(dataModule, interactorModule, viewModelModule)
}