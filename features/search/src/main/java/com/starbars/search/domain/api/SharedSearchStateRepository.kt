package com.starbars.search.domain.api

import com.starbars.search.domain.model.BottomSheetState

internal interface SharedSearchStateRepository {
    fun getStateBS() : BottomSheetState?
    fun updateBSState(state: BottomSheetState?)
}