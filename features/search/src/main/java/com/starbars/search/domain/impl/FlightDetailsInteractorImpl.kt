package com.starbars.search.domain.impl

import com.starbars.search.domain.api.FlightDetailsInteractor
import com.starbars.search.domain.api.FlightDetailsRepository
import com.starbars.search.domain.model.TicketOffer
import com.starbars.util.network.Resource

internal class FlightDetailsInteractorImpl(
    private val repository: FlightDetailsRepository
) : FlightDetailsInteractor {
    override suspend fun getTicketOffers(): Resource<List<TicketOffer>> {
        return repository.getTicketsOffers()
    }
}