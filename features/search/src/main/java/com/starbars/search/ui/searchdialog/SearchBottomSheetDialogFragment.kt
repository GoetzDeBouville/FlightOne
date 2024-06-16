package com.starbars.search.ui.searchdialog

import androidx.fragment.app.viewModels
import com.starbars.presentation.BottomSheetBaseFragment
import com.starbars.search.databinding.FragmentSearchBottomSheetDialogBinding


class SearchBottomSheetDialogFragment :
    BottomSheetBaseFragment<FragmentSearchBottomSheetDialogBinding, SearchDialogViewModel>(
        FragmentSearchBottomSheetDialogBinding::inflate
    ) {
    override val viewModel: SearchDialogViewModel by viewModels()
}