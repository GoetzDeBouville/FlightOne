package com.starbars.search.di

import com.starbars.search.domain.api.FlightDetailsInteractor
import com.starbars.search.domain.api.SearchInteractor
import com.starbars.search.domain.api.SharedSearchStateInteractor
import com.starbars.search.domain.api.TicketsInteractor
import com.starbars.search.domain.impl.FlightDetailsInteractorImpl
import com.starbars.search.domain.impl.SearchInteractorImpl
import com.starbars.search.domain.impl.SharedSearchStateInteractorImpl
import com.starbars.search.domain.impl.TicketsInteractorImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


internal val interactorModule = module {
    singleOf(::SearchInteractorImpl) { bind<SearchInteractor>() }
    singleOf(::FlightDetailsInteractorImpl) { bind<FlightDetailsInteractor>() }
    singleOf(::TicketsInteractorImpl) { bind<TicketsInteractor>() }
    singleOf(::SharedSearchStateInteractorImpl) {bind<SharedSearchStateInteractor>()}
}