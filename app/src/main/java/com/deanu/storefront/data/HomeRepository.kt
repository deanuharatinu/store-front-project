package com.deanu.storefront.data

import com.deanu.storefront.data.model.StoreItemModel

interface HomeRepository {

    suspend fun getAllStoreItems(): List<StoreItemModel>
}