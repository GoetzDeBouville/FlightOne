package com.starbars.search.data.repository

import com.starbars.search.data.api.SearchRemoteDataSource
import com.starbars.search.data.converter.convert
import com.starbars.search.domain.api.TicketsRepository
import com.starbars.search.domain.model.Ticket
import com.starbars.util.network.Resource


internal class TicketsRepositoryImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : TicketsRepository {
    override suspend fun getTickets(): Resource<List<Ticket>> {
        return try {
            val response = searchRemoteDataSource.getAllTickets()
            Resource.Success(response.tickets.map { it.convert() })
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}