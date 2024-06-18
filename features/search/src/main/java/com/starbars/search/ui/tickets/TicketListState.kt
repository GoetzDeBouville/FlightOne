package com.starbars.search.ui.tickets

import com.starbars.search.domain.model.Ticket

internal sealed interface TicketListState {

    data object Default : TicketListState

    data class Content(
        val tickets: List<Ticket>
    ) : TicketListState
}