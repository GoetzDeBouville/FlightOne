package com.starbars.search.ui.preliminarysearchresult

import androidx.fragment.app.viewModels
import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentPreliminaryResultBinding

internal class PreliminarySearchResultFragment :
    BaseFragment<FragmentPreliminaryResultBinding, PreliminarySearchResultViewModel>(
        FragmentPreliminaryResultBinding::inflate
    ) {
    override val viewModel: PreliminarySearchResultViewModel by viewModels()
}