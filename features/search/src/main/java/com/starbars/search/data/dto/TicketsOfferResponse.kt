package com.starbars.search.data.dto

import com.google.gson.annotations.SerializedName

internal data class TicketsOfferResponse(
    @SerializedName("tickets_offers") val ticketsOffer: List<TicketOfferDto>
)