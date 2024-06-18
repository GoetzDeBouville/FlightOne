package com.starbars.search.ui.filter

import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentFilterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class FilterFragment : BaseFragment<FragmentFilterBinding, FilterViewModel>(
    FragmentFilterBinding::inflate
) {
    override val viewModel: FilterViewModel by viewModel()
}