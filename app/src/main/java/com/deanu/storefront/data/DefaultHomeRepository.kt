package com.deanu.storefront.data

import com.deanu.storefront.data.local.StoreFrontDatabase
import com.deanu.storefront.data.local.entities.StoreItemEntity
import com.deanu.storefront.data.models.StoreItemModel
import com.deanu.storefront.data.remote.StoreItemApiService

class DefaultHomeRepository(
    private val storeItemRemoteSource: StoreItemApiService,
    private val storeItemLocalSource: StoreFrontDatabase
) : HomeRepository {

    override suspend fun getAllStoreItems(): List<StoreItemModel> {
        return storeItemRemoteSource.getStoreItems()
    }

    override suspend fun insertAllStoreItems(storeItemList: List<StoreItemEntity>) {
        storeItemLocalSource.storeItemDao.insertAll(storeItemList)
    }
}