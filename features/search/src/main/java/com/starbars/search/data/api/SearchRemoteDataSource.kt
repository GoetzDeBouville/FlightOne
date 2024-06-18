package com.starbars.search.data.api

import com.starbars.search.data.dto.TicketListResponse
import com.starbars.search.data.dto.ConcertsOfferResponse
import com.starbars.search.data.dto.TicketsOfferResponse

internal interface SearchRemoteDataSource {
    suspend fun getAllTickets(): TicketListResponse
    suspend fun getConcertsOffer(): ConcertsOfferResponse
    suspend fun getTicketsOffer(): TicketsOfferResponse
}