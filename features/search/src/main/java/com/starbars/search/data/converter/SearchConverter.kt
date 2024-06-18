package com.starbars.search.data.converter

import com.starbars.search.data.dto.BottomSheetStateDto
import com.starbars.search.data.dto.ConcertOfferDto
import com.starbars.search.data.dto.TicketDto
import com.starbars.search.data.dto.TicketOfferDto
import com.starbars.search.domain.model.BottomSheetState
import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.domain.model.Ticket
import com.starbars.search.domain.model.TicketOffer
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale


internal fun TicketOfferDto.convert() = TicketOffer(
    id = id,
    timeRange = timeRange.joinToString(" "),
    title = title,
    price = price.value.formatPrice()
)

internal fun TicketDto.convert() = Ticket(
    id = id,
    price = price.value.formatPrice(),
    arrivalTime = arrival.date.getTimeFromDate(),
    departureTime = departure.date.getTimeFromDate(),
    departureAirportCode = departure.airport,
    arrivalAirportCode = arrival.airport,
    badge = badge,
    hasTransfer = hasTransfer,
    travelTime = arrival.date.countTravelTime(departure.date)
)

internal fun ConcertOfferDto.convert() = ConcertOffer(
    id = id,
    title = title,
    city = town,
    price = price.value.formatPrice(),
    imageResId = id.getConcertOfferImageResId()
)

private fun Int.formatPrice(): String {
    val format = NumberFormat.getInstance(Locale.US)
    return format.format(this).replace(",", " ")
}

private fun String.getTimeFromDate() = substringAfter('T').substringBeforeLast(":")


private fun Int.getConcertOfferImageResId(): Int {
    return when (this) {
        1 -> com.starbars.uikit.R.drawable.img_1
        2 -> com.starbars.uikit.R.drawable.img_2
        3 -> com.starbars.uikit.R.drawable.img_6
        else -> 0
    }
}

private fun String.countTravelTime(departure: String): String {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
    val startDate = format.parse(departure)
    val endDate = format.parse(this)

    val durationMillis = endDate.time - startDate.time
    val hours = durationMillis.toDouble() / (1000 * 60 * 60)
    return hours.toString()
}

internal fun BottomSheetStateDto.convert() = BottomSheetState(
    departureCity = departureCity,
    arrivalCity = arrivalCity
)


internal fun BottomSheetState.convert() = BottomSheetStateDto(
    departureCity = departureCity,
    arrivalCity = arrivalCity
)