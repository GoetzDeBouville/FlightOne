package com.starbars.search.ui.searchdialog

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.starbars.presentation.BottomSheetBaseFragment
import com.starbars.search.R
import com.starbars.search.databinding.FragmentSearchBottomSheetDialogBinding
import com.starbars.search.domain.model.PlaceOffer
import com.starbars.search.ui.searchdialog.adapter.FamousRouteAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SearchBottomSheetDialogFragment :
    BottomSheetBaseFragment<FragmentSearchBottomSheetDialogBinding, SearchDialogViewModel>(
        FragmentSearchBottomSheetDialogBinding::inflate
    ) {
    override val viewModel: SearchDialogViewModel by viewModel()
    private val famousRouteAdapter = FamousRouteAdapter {
        binding.inputBlock.etArrivalCity.setText(it)
    }

    private var cityDeparture: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityDeparture = it.getString(ARG_DEPARTURE_CITY) ?: ""
        }
    }

    override fun initViews() {
        super.initViews()
        initAdapter()
        buildBottomSheet()
    }

    override fun subscribe() {
        super.subscribe()
        observeDialogState()
        observeVMState()
        observeTextInput()
        setOnClearBtnClickListener()
        with(binding) {
            oivAnywhere.setOnClickListener {
                inputBlock.etArrivalCity.setText(oivAnywhere.getText())
            }

            listOf(oivWeekends, oivHotFlights, oivComplicatedRoute).forEach {
                it.setOnClickListener {
                    findNavController().navigate(R.id.action_searchFragment_to_emptyFragment)
                    dismiss()
                }
            }
        }
    }

    private fun buildBottomSheet() {
        dialog?.setOnShowListener { dialog ->
            val bottomSheet =
                (dialog as BottomSheetDialog)
                    .findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheetBehavior.apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = Resources.getSystem().displayMetrics.heightPixels
            }.addBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(p0: View, p1: Int) {
                    if (p1 == BottomSheetBehavior.STATE_HIDDEN) {
                        viewModel.setDefaultStateDialog()
                    }
                }

                override fun onSlide(p0: View, p1: Float) = Unit
            })
            bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    private fun initAdapter() {
        binding.rvPopularPlaces.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = famousRouteAdapter
        }
    }

    private fun showContent(content: SearchDialogState.Content) {
        binding.inputBlock.etDepartureCity.setText(content.lastDeparturePlace)
        setDestinationOffers(content.destinationOffers)
    }


    private fun setDestinationOffers(list: List<PlaceOffer>) {
        if (list.isEmpty()) {
            binding.rvPopularPlaces.isVisible = false
        } else {
            binding.rvPopularPlaces.isVisible = true
            famousRouteAdapter.submitList(list)
        }
    }

    private fun observeDialogState() {
        lifecycleScope.launch {
            viewModel.dialogState.collect { state ->
                renderEditextState(state)
            }
        }
    }

    private fun renderEditextState(state: SharedSearchState) = with(binding.inputBlock) {
        when (state) {
            is SharedSearchState.BottomSheetOpen -> {
                etArrivalCity.setText(state.arrivalCity)
                if (state.departureCity.isNotEmpty()) {
                    etDepartureCity.setText(state.departureCity)
                }
            }

            else -> Unit
        }
    }

    private fun observeVMState() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    renderUi(it)
                }
            }
        }
    }

    private fun renderUi(state: SearchDialogState) {
        when (state) {
            is SearchDialogState.Content -> {
                showContent(state)
            }

            SearchDialogState.Default -> Unit
        }
    }

    private fun setOnClearBtnClickListener() {
        binding.inputBlock.ivCross.setOnClickListener {
            binding.inputBlock.etArrivalCity.text.clear()
        }
    }

    private fun observeTextInput() = with(binding.inputBlock) {
        etDepartureCity.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                etArrivalCity.setText(etArrivalCity.text.toString())
                viewModel.searchTickets(
                    from = etDepartureCity.text.toString(),
                    to = etArrivalCity.text.toString()
                )
            }
            false
        }
    }

    companion object {
        private const val ARG_DEPARTURE_CITY = "city_departure"

        fun newInstance(cityDeparture: String): SearchBottomSheetDialogFragment {
            val fragment = SearchBottomSheetDialogFragment()
            val args = Bundle().apply {
                putString(ARG_DEPARTURE_CITY, cityDeparture)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
