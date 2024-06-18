package com.starbars.search.data.repository

import com.starbars.search.data.api.SearchRemoteDataSource
import com.starbars.search.data.converter.convert
import com.starbars.search.domain.api.FlightDetailsRepository
import com.starbars.search.domain.model.TicketOffer
import com.starbars.util.network.Resource


internal class FlightDetailsRepositoryImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : FlightDetailsRepository {

    override suspend fun getTicketsOffers(): Resource<List<TicketOffer>> {
        return try {
            val response = searchRemoteDataSource.getTicketsOffer()
            Resource.Success(response.ticketsOffer.map { it.convert() })
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}