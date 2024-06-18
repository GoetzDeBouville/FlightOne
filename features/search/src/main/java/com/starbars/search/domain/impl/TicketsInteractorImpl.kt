package com.starbars.search.domain.impl

import com.starbars.search.domain.api.TicketsInteractor
import com.starbars.search.domain.api.TicketsRepository
import com.starbars.search.domain.model.Ticket
import com.starbars.util.network.Resource

internal class TicketsInteractorImpl(
    private val repository: TicketsRepository
) : TicketsInteractor {
    override suspend fun getTickets(): Resource<List<Ticket>> {
        return repository.getTickets()
    }
}