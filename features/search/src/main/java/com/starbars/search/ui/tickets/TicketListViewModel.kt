package com.starbars.search.ui.tickets

import androidx.lifecycle.viewModelScope
import com.starbars.presentation.BaseViewModel
import com.starbars.search.domain.api.TicketsInteractor
import com.starbars.util.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class TicketListViewModel(
    private val ticketsInteractor: TicketsInteractor
) : BaseViewModel() {
    private val _state =
        MutableStateFlow<TicketListState>(TicketListState.Default)
    val state: StateFlow<TicketListState>
        get() = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {

            _state.value = TicketListState.Content(
                tickets = when (val resource = ticketsInteractor.getTickets()) {
                    is Resource.Error -> {
                        emptyList()
                    }

                    is Resource.Success -> {
                        resource.data!!
                    }
                }
            )
        }
    }
}