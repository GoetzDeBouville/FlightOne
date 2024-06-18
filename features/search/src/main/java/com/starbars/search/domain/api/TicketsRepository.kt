package com.starbars.search.domain.api

import com.starbars.search.domain.model.Ticket
import com.starbars.util.network.Resource

internal interface TicketsRepository {
    suspend fun getTickets(): Resource<List<Ticket>>
}