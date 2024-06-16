package com.starbars.search.ui

import androidx.fragment.app.viewModels
import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentSearchBinding

internal class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewmodel>(FragmentSearchBinding::inflate) {
    override val viewModel: SearchViewmodel by viewModels()
}