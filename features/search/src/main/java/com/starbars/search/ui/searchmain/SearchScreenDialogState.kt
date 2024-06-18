package com.starbars.search.ui.searchmain

internal sealed interface SearchScreenDialogState {

    data class ShowDialogFragment(
        val from: String,
        val to: String
    ) : SearchScreenDialogState
}