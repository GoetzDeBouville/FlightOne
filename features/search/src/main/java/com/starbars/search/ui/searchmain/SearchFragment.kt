package com.starbars.search.ui.searchmain

import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.starbars.presentation.BaseFragment
import com.starbars.search.databinding.FragmentSearchBinding
import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.ui.searchdialog.SearchBottomSheetDialogFragment
import com.starbars.search.ui.searchmain.adapter.ConcertOfferAdapter
import com.starbars.search.ui.searchdialog.SharedSearchState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewmodel>(FragmentSearchBinding::inflate) {

    override val viewModel: SearchViewmodel by viewModel()
    private val concertsAdapter = ConcertOfferAdapter()

    override fun initViews() {
        super.initViews()
        initAdapter()
        setTextDeparture()
    }

    override fun subscribe() {
        super.subscribe()
        observeContentState()
        observeDialogState()
        etArrivalClickListener()
    }

    private fun etArrivalClickListener() = with(binding) {
        inputBlock.etArrivalCity.setOnClickListener {
            showBottomSheetFragment(inputBlock.etDepartureCity.text.toString())
        }
    }

    private fun initAdapter() {
        binding.rvConcertsOffer.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = concertsAdapter
        }
    }

    private fun renderUi(state: SearchScreenState) {
        when (state) {
            is SearchScreenState.Content -> {
                showContent(state)
            }

            SearchScreenState.Default -> {
                // Set default state UI
            }
        }
    }

    private fun observeDialogState() {
        lifecycleScope.launch {
            viewModel.dialogState.collect { state ->
                Log.i("MyLog", "state = $state")
                when (state) {
                    is SharedSearchState.Default -> Unit
                    is SharedSearchState.BottomSheetOpen -> {
                        showBottomSheetFragment(state.departureCity)
                    }
                }
            }
        }
    }

    private fun observeContentState() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    renderUi(it)
                }
            }
        }
    }

    private fun showContent(content: SearchScreenState.Content) {
        binding.inputBlock.etDepartureCity.setText(content.lastDeparturePlace)
        setConcertOffers(content.concertOffers)
    }

    private fun setConcertOffers(list: List<ConcertOffer>) = with(binding) {
        if (list.isEmpty()) {
            tvHeaderConcerts.isVisible = false
        } else {
            tvHeaderConcerts.isVisible = true
            concertsAdapter.submitList(list)
        }
    }

    private fun showBottomSheetFragment(departureCity: String) {
        val bottomSheetFragment = SearchBottomSheetDialogFragment.newInstance(departureCity)
        bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
    }

    private fun setTextDeparture() {
        binding.inputBlock.etDepartureCity.setText("Москва")
    }
}