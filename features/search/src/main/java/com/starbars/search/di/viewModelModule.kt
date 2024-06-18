package com.starbars.search.di

import com.starbars.search.ui.preliminarysearchresult.PreliminarySearchResultViewModel
import com.starbars.search.ui.searchdialog.SearchDialogViewModel
import com.starbars.search.ui.searchmain.SearchViewmodel
import com.starbars.search.ui.tickets.TicketListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


internal val viewModelModule = module {

    viewModel {
        SearchViewmodel(
            searchInteractor = get(),
            sharedSearchStateInteractor = get()
        )
    }

    viewModel {
        PreliminarySearchResultViewModel(
            flightDetailsInteractor = get()
        )
    }

    viewModel {
        TicketListViewModel(
            ticketsInteractor = get()
        )
    }

    viewModel {
        SearchDialogViewModel(
            searchInteractor = get(),
            sharedSearchStateInteractor = get()
        )
    }
}