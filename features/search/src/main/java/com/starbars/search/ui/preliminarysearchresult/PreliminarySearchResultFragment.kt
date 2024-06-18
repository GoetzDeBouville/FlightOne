package com.starbars.search.ui.preliminarysearchresult

import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentPreliminaryResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PreliminarySearchResultFragment :
    BaseFragment<FragmentPreliminaryResultBinding, PreliminarySearchResultViewModel>(
        FragmentPreliminaryResultBinding::inflate
    ) {
    override val viewModel: PreliminarySearchResultViewModel by viewModel()
}