package com.starbars.search.domain.model

internal data class PlaceOffer(
    override val id: Int,
    val city: String,
    val description: String,
    val imageResId: Int
) : BaseIdentifiable(id)
