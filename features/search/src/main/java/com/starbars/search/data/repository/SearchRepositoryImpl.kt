package com.starbars.search.data.repository

import com.starbars.search.data.api.SearchRemoteDataSource
import com.starbars.search.data.converter.convert
import com.starbars.search.data.impl.SearchMockDataSource
import com.starbars.search.data.prefs.LastPlaceStorage
import com.starbars.search.domain.api.SearchRepository
import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.domain.model.PlaceOffer
import com.starbars.util.network.Resource

internal class SearchRepositoryImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val searchMockDataSource: SearchMockDataSource,
    private val lastPlaceStorage: LastPlaceStorage
) : SearchRepository {

    override suspend fun getConcertOffers(): Resource<List<ConcertOffer>> {
        return try {
            val response = searchRemoteDataSource.getConcertsOffer()
            Resource.Success(response.offers.map { it.convert() })
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }

    override fun getDestinationRecommendations(): List<PlaceOffer> {
        return searchMockDataSource.getDestinationRecommendations()
    }

    override fun getLastDeparturePlace(): String? {
        return lastPlaceStorage.get()
    }

    override fun saveLastDeparturePlace(place: String) {
        lastPlaceStorage.save(place)
    }
}