package com.deanu.storefront.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.deanu.storefront.databinding.HomeFragBinding

class HomeFragment : Fragment() {
    private var _binding: HomeFragBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragBinding.inflate(inflater, container, false)
        val view = binding.root

        val viewModelFactory = HomeViewModelFactory(requireActivity().applicationContext)
        val viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]



        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}