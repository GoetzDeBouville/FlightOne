package com.starbars.search.ui.preliminarysearchresult

import com.starbars.search.domain.model.TicketOffer

internal sealed interface PreliminaryResultState {

    data object Default : PreliminaryResultState

    data class Content(
        val ticketOffers: List<TicketOffer>
    ) : PreliminaryResultState
}