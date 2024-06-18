package com.starbars.search.data.impl

import android.content.Context
import com.starbars.search.data.api.ApiService
import com.starbars.search.data.api.SearchRemoteDataSource
import com.starbars.search.data.dto.TicketListResponse
import com.starbars.search.data.dto.ConcertsOfferResponse
import com.starbars.search.data.dto.TicketsOfferResponse
import com.starbars.util.extensions.isConnected
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class SearchRemoteDataSourceImpl(
    private val context: Context,
    private val apiService: ApiService
) : SearchRemoteDataSource {
    override suspend fun getConcertsOffer(): ConcertsOfferResponse {
        checkInternetConnection()
        return withContext(Dispatchers.IO) {
            apiService.getConcertsOffer()
        }
    }

    override suspend fun getTicketsOffer(): TicketsOfferResponse {
        checkInternetConnection()
        return withContext(Dispatchers.IO) {
            apiService.getTicketsOffer()
        }
    }

    override suspend fun getAllTickets(): TicketListResponse {
        checkInternetConnection()
        return withContext(Dispatchers.IO) {
            apiService.getAllTickets()
        }
    }

    private fun checkInternetConnection() {
        if (context.isConnected().not()) {
            throw RuntimeException("No internet connection")
        }
    }
}