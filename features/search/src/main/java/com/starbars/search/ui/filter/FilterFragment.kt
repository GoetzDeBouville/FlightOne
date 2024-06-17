package com.starbars.search.ui.filter

import androidx.fragment.app.viewModels
import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentFilterBinding

class FilterFragment : BaseFragment<FragmentFilterBinding, FilterViewModel>(
    FragmentFilterBinding::inflate
) {
    override val viewModel: FilterViewModel by viewModels()
}