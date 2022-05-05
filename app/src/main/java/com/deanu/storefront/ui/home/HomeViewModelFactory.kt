package com.deanu.storefront.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deanu.storefront.utils.ServiceLocator

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(ServiceLocator.provideHomeRepository(context)) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}