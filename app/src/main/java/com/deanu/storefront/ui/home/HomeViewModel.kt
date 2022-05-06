package com.deanu.storefront.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deanu.storefront.data.HomeRepository
import com.deanu.storefront.data.models.StoreItemModel
import com.deanu.storefront.data.models.asEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: HomeRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    ViewModel() {
    private val _status = MutableLiveData(false)
    val status: LiveData<Boolean> = _status

    private val _storeItemList = MutableLiveData<List<StoreItemModel>>()
    val storeItemList: LiveData<List<StoreItemModel>> = _storeItemList

    init {
        getStoreItems()
    }

    fun storeInteger() {
        viewModelScope.launch(ioDispatcher) {
            try {
                repository.insertAllStoreItems(_storeItemList.value!!.asEntity())
            } catch (e: Exception) {
                Log.e("storeInteger: ", "${e.message}")
            }
        }
    }

    private fun getStoreItems() {
        viewModelScope.launch {
            try {
                _storeItemList.value = repository.getAllStoreItems()
                _status.value = true
            } catch (e: Exception) {
                _status.value = false
                Log.e("getStoreitems", "${e.message}")
            }
        }
    }
}