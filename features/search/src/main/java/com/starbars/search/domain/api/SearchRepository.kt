package com.starbars.search.domain.api

import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.domain.model.PlaceOffer
import com.starbars.util.network.Resource

internal interface SearchRepository {
    suspend fun getConcertOffers(): Resource<List<ConcertOffer>>

    fun getDestinationRecommendations(): List<PlaceOffer>

    fun getLastDeparturePlace(): String?

    fun saveLastDeparturePlace(place: String)
}