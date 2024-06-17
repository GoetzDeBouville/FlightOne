package com.starbars.search.ui.tickets

import androidx.fragment.app.viewModels
import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentTicketListBinding

internal class TicketListFragment : BaseFragment<FragmentTicketListBinding, TicketListViewModel>(
    FragmentTicketListBinding::inflate
) {
    override val viewModel: TicketListViewModel by viewModels()
}