package com.starbars.search.domain.api

import com.starbars.search.domain.model.TicketOffer
import com.starbars.util.network.Resource


internal interface FlightDetailsRepository {
    suspend fun getTicketsOffers(): Resource<List<TicketOffer>>
}