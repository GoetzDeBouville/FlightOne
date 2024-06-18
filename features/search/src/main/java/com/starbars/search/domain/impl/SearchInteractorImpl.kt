package com.starbars.search.domain.impl

import com.starbars.search.domain.api.SearchInteractor
import com.starbars.search.domain.api.SearchRepository
import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.domain.model.PlaceOffer
import com.starbars.util.network.Resource

internal class SearchInteractorImpl(
    private val repository: SearchRepository
) : SearchInteractor {
    override suspend fun getConcertOffers(): Resource<List<ConcertOffer>> {
        return repository.getConcertOffers()
    }

    override fun getDestinationRecommendations(): List<PlaceOffer> {
        return repository.getDestinationRecommendations()
    }

    override fun getLastDeparturePlace(): String? {
        return repository.getLastDeparturePlace()
    }

    override fun saveLastDeparturePlace(place: String) {
        repository.saveLastDeparturePlace(place)
    }
}