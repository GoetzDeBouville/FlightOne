package com.starbars.search.domain.model

internal data class TicketOffer(
    override val id: Int,
    val price: String,
    val timeRange: String,
    val title: String
) : BaseIdentifiable(id)