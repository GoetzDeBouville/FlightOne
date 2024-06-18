package com.starbars.search.ui.searchdialog

import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.domain.model.PlaceOffer


internal sealed interface SearchDialogState {

    data object Default : SearchDialogState

    data class Content(
        val lastDeparturePlace: String,
        val destinationOffers: List<PlaceOffer>
    ) : SearchDialogState
}