package com.deanu.storefront.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deanu.storefront.data.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getStoreItems()
    }

    private fun getStoreItems() {
        viewModelScope.launch {
            try {
                val listResult = repository.getAllStoreItems()
                _status.value = "Success: ${listResult.size} store items retrieved"
            } catch (e: Exception) {
                _status.value = "Failed"
            }
        }
    }
}