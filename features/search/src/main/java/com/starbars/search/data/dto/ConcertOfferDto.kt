package com.starbars.search.data.dto

internal data class ConcertOfferDto(
    val id: Int,
    val price: PriceDto,
    val title: String,
    val town: String
)