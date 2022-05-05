package com.deanu.storefront.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deanu.storefront.data.HomeRepository
import com.deanu.storefront.data.model.StoreItemModel
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _storeItemList = MutableLiveData<List<StoreItemModel>>()
    val storeItemList: LiveData<List<StoreItemModel>> = _storeItemList

    init {
        getStoreItems()
    }

    private fun getStoreItems() {
        viewModelScope.launch {
            try {
                _storeItemList.value = repository.getAllStoreItems()
                _status.value = "Success: ${storeItemList.value?.size ?: 0} store items retrieved"
            } catch (e: Exception) {
                _status.value = "Failed"
            }
        }
    }
}