package com.deanu.storefront.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.deanu.storefront.databinding.HomeFragBinding
import com.deanu.storefront.ui.adapter.StoreItemAdapter

class HomeFragment : Fragment() {
    private var _binding: HomeFragBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = StoreItemAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.storeItemList.observe(viewLifecycleOwner) { list ->
            list?.let { adapter.submitList(list) }
        }

        viewModel.status.observe(viewLifecycleOwner) { isDataReady ->
            if (isDataReady) viewModel.storeInteger()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}