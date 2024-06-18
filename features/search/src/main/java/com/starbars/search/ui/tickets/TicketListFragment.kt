package com.starbars.search.ui.tickets

import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentTicketListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TicketListFragment : BaseFragment<FragmentTicketListBinding, TicketListViewModel>(
    FragmentTicketListBinding::inflate
) {
    override val viewModel: TicketListViewModel by viewModel()
}