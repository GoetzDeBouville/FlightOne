package com.starbars.search.ui.searchdialog

internal sealed class SharedSearchState {
    object Default : SharedSearchState()
    data class BottomSheetOpen(
        val departureCity: String,
        val arrivalCity: String
    ) : SharedSearchState()
}