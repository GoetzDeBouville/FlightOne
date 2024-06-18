package com.starbars.search.ui.preliminarysearchresult

import androidx.lifecycle.viewModelScope
import com.starbars.presentation.BaseViewModel
import com.starbars.search.domain.api.FlightDetailsInteractor
import com.starbars.util.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class PreliminarySearchResultViewModel(
    private val flightDetailsInteractor: FlightDetailsInteractor
) : BaseViewModel() {
    private val _state =
        MutableStateFlow<PreliminaryResultState>(PreliminaryResultState.Default)
    val state: StateFlow<PreliminaryResultState>
        get() = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = PreliminaryResultState.Content(
                ticketOffers = when (val resource = flightDetailsInteractor.getTicketOffers()) {
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