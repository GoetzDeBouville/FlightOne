package com.starbars.search.data.api

import com.starbars.search.data.dto.TicketListResponse
import com.starbars.search.data.dto.ConcertsOfferResponse
import com.starbars.search.data.dto.TicketsOfferResponse
import retrofit2.http.GET


internal interface ApiService {
    @GET("/uc?export=download&id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
    suspend fun getAllTickets(): TicketListResponse
    @GET("/uc?export=download&id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav")
    suspend fun getConcertsOffer(): ConcertsOfferResponse

    @GET("/uc?export=download&id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta")
    suspend fun getTicketsOffer(): TicketsOfferResponse
}