package com.starbars.search.data.repository

import com.starbars.search.data.converter.convert
import com.starbars.search.data.dto.BottomSheetStateDto
import com.starbars.search.domain.api.SharedSearchStateRepository
import com.starbars.search.domain.model.BottomSheetState

internal class SharedSearchStateRepositoryImpl : SharedSearchStateRepository {
    private var bottomSheetState: BottomSheetStateDto? = null

    override fun getStateBS() = bottomSheetState?.convert()
    override fun updateBSState(state: BottomSheetState?) {
        bottomSheetState = state?.convert()
    }
}