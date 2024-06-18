package com.starbars.search.ui.searchmain

import com.starbars.search.domain.model.ConcertOffer

internal sealed interface SearchScreenState {

    data object Default : SearchScreenState

    data class Content(
        val lastDeparturePlace: String,
        val concertOffers: List<ConcertOffer>
    ) : SearchScreenState
}