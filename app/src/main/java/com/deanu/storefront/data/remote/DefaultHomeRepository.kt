package com.deanu.storefront.data.remote

import com.deanu.storefront.data.HomeRepository
import com.deanu.storefront.data.model.StoreItemModel

class DefaultHomeRepository(private val storeItemRemoteSource: StoreItemApiService) : HomeRepository {

    override suspend fun getAllStoreItems(): List<StoreItemModel> {
        return storeItemRemoteSource.getStoreItems()
    }
}