package com.starbars.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentSearchBinding

internal class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewmodel>(FragmentSearchBinding::inflate) {
    override val viewModel: SearchViewmodel by viewModels()
}