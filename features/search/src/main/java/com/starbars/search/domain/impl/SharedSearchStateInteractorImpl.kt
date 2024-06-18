package com.starbars.search.domain.impl

import com.starbars.search.domain.api.SharedSearchStateInteractor
import com.starbars.search.domain.api.SharedSearchStateRepository
import com.starbars.search.domain.model.BottomSheetState

internal class SharedSearchStateInteractorImpl(
    private val repository: SharedSearchStateRepository
): SharedSearchStateInteractor {
    override fun getStateBS() = repository.getStateBS()
    override fun updateBSState(state: BottomSheetState?) {
        repository.updateBSState(state)
    }
}