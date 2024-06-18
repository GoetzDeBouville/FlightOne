package com.starbars.search.domain.model

internal data class ConcertOffer(
    override val id: Int,
    val title: String,
    val city: String,
    val imageResId: Int,
    val price: String
) : BaseIdentifiable(id)
