package com.deanu.storefront.data

import com.deanu.storefront.data.local.entities.StoreItemEntity
import com.deanu.storefront.data.models.StoreItemModel

interface HomeRepository {

    suspend fun getAllStoreItems(): List<StoreItemModel>

    suspend fun insertAllStoreItems(storeItemList: List<StoreItemEntity>)
}