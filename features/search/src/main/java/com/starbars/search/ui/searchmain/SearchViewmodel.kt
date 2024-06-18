package com.starbars.search.ui.searchmain

import androidx.lifecycle.viewModelScope
import com.starbars.search.domain.api.SearchInteractor
import com.starbars.search.domain.api.SharedSearchStateInteractor
import com.starbars.search.ui.sharedvm.SharedSearchViewModel
import com.starbars.util.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class SearchViewmodel(
    private val searchInteractor: SearchInteractor,
    private val sharedSearchStateInteractor: SharedSearchStateInteractor
) : SharedSearchViewModel(sharedSearchStateInteractor) {
    private val _state = MutableStateFlow<SearchScreenState>(SearchScreenState.Default)
    val state: StateFlow<SearchScreenState>
        get() = _state

    init {
        loadData()
    }

    private fun loadData() {
        val lastDeparturePlace = searchInteractor.getLastDeparturePlace().orEmpty()
        viewModelScope.launch {
            val concertOffers = when (
                val resource = searchInteractor.getConcertOffers()
            ) {
                is Resource.Error -> {
                    emptyList()
                }

                is Resource.Success -> resource.data
            }
            _state.value = SearchScreenState.Content(
                lastDeparturePlace = lastDeparturePlace,
                concertOffers = concertOffers ?: emptyList()
            )
        }
    }
}
