package com.starbars.search.data.impl

import android.content.Context
import com.starbars.search.domain.model.PlaceOffer

internal class SearchMockDataSource(
    context: Context
) {

    private val destinationRecommendations = listOf(
        PlaceOffer(
            id = 1,
            city = "Станбул",
            description = context.getString(com.starbars.uikit.R.string.favorite_route),
            imageResId = com.starbars.uikit.R.drawable.img_4
        ),
        PlaceOffer(
            id = 2,
            city = "Сочи",
            description = context.getString(com.starbars.uikit.R.string.favorite_route),
            imageResId = com.starbars.uikit.R.drawable.img_5
        ),
        PlaceOffer(
            id = 3,
            city = "Пхукет",
            description = context.getString(com.starbars.uikit.R.string.favorite_route),
            imageResId = com.starbars.uikit.R.drawable.img_6
        )
    )

    fun getDestinationRecommendations() = destinationRecommendations
}