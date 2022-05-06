package com.deanu.storefront.data.remote

import com.deanu.storefront.StoreFrontApp
import com.deanu.storefront.data.models.StoreItemModel
import com.deanu.storefront.utils.PRODUCTS_API
import retrofit2.http.GET

interface StoreItemApiService {
    @GET(PRODUCTS_API)
    suspend fun getStoreItems(): List<StoreItemModel>

    companion object {
        val retrofitService: StoreItemApiService by lazy {
            StoreFrontApp.retrofit.create(StoreItemApiService::class.java)
        }
    }
}