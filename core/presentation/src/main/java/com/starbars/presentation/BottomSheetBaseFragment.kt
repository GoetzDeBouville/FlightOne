package com.starbars.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BottomSheetBaseFragment<VB : ViewBinding, VM : BaseViewModel>(private val inflate: Inflate<VB>) :
    BottomSheetDialogFragment() {
    abstract val viewModel: VM
    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = this.inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun initViews() = Unit

    open fun subscribe() = Unit
}