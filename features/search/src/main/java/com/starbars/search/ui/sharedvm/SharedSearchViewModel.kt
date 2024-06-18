package com.starbars.search.ui.sharedvm

import com.starbars.presentation.BaseViewModel
import com.starbars.search.domain.api.SharedSearchStateInteractor
import com.starbars.search.domain.model.BottomSheetState
import com.starbars.search.ui.searchdialog.SharedSearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal open class SharedSearchViewModel(
    private val sharedSearchStateInteractor: SharedSearchStateInteractor
) : BaseViewModel() {
    protected val _dialogState = MutableStateFlow<SharedSearchState>(SharedSearchState.Default)
    val dialogState: StateFlow<SharedSearchState> get() = _dialogState

    fun getBsState() {
        val state = sharedSearchStateInteractor.getStateBS()
        _dialogState.value = if (state == null) {
            SharedSearchState.Default
        } else {
            SharedSearchState.BottomSheetOpen(
                state.departureCity,
                state.arrivalCity
            )
        }
    }

    fun setOpenStateDialog(state : SharedSearchState.BottomSheetOpen) {
        _dialogState.value = state
    }

    fun setDefaultStateDialog() {
        _dialogState.value = SharedSearchState.Default
    }
}