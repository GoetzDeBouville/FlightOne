package com.starbars.search.domain.api

import com.starbars.search.domain.model.BottomSheetState

internal interface SharedSearchStateInteractor {
    fun getStateBS() : BottomSheetState?
    fun updateBSState(state: BottomSheetState?)
}