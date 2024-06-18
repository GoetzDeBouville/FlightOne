package com.starbars.search.domain.model

internal data class Ticket(
    override val id: Int,
    val arrivalTime: String,
    val arrivalAirportCode: String,
    val departureAirportCode: String,
    val badge: String?,
    val departureTime: String,
    val hasTransfer: Boolean,
    val price: String,
    val travelTime: String
) : BaseIdentifiable(id)