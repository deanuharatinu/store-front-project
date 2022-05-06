package com.deanu.storefront.utils

import com.deanu.storefront.data.HomeRepository
import com.deanu.storefront.data.local.StoreFrontDatabase.Companion.storeFrontDatabase
import com.deanu.storefront.data.DefaultHomeRepository
import com.deanu.storefront.data.remote.StoreItemApiService.Companion.retrofitService

object ServiceLocator {
    @Volatile
    var homeRepository: HomeRepository? = null

    fun provideHomeRepository(): HomeRepository {
        synchronized(this) {
            return homeRepository ?: homeRepository ?: createHomeRepository()
        }
    }

    private fun createHomeRepository(): HomeRepository {
        val newRepo = DefaultHomeRepository(retrofitService, storeFrontDatabase)
        homeRepository = newRepo
        return newRepo
    }
}