package com.starbars.search.ui.searchdialog

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.starbars.search.domain.api.SearchInteractor
import com.starbars.search.domain.api.SharedSearchStateInteractor
import com.starbars.search.ui.sharedvm.SharedSearchViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class SearchDialogViewModel(
    private val searchInteractor: SearchInteractor,
    private val sharedSearchStateInteractor: SharedSearchStateInteractor
) : SharedSearchViewModel(sharedSearchStateInteractor) {
    private val _state = MutableStateFlow<SearchDialogState>(SearchDialogState.Default)
    val state: StateFlow<SearchDialogState>
        get() = _state

    init {
        loadData()
        updateDialogState()
    }

    private fun loadData() {
        viewModelScope.launch {
            val lastDeparturePlace = searchInteractor.getLastDeparturePlace().orEmpty()
            val destinationOffers = searchInteractor.getDestinationRecommendations()
            _state.value = SearchDialogState.Content(
                lastDeparturePlace = lastDeparturePlace,
                destinationOffers = destinationOffers
            )
        }
    }

    fun searchTickets(from: String, to: String) {
        searchInteractor.saveLastDeparturePlace(from)
        setOpenStateDialog(SharedSearchState.BottomSheetOpen(from, to))
    }

    private fun updateDialogState() {
        Log.i("MyLog", "updateDialogState _dialogState = $_dialogState")

        _dialogState.value = SharedSearchState.BottomSheetOpen(
            "",
            ""
        )
    }
}