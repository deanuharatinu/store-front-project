package com.deanu.storefront.utils

import android.content.Context
import com.deanu.storefront.data.HomeRepository
import com.deanu.storefront.data.remote.DefaultHomeRepository
import com.deanu.storefront.data.remote.StoreItemApiService.Companion.retrofitService

object ServiceLocator {
    @Volatile
    var homeRepository: HomeRepository? = null

    fun provideHomeRepository(context: Context): HomeRepository {
        synchronized(this) {
            return homeRepository ?: homeRepository ?: createHomeRepository(context)
        }
    }

    private fun createHomeRepository(context: Context): HomeRepository {
        val newRepo = DefaultHomeRepository(retrofitService)
        homeRepository = newRepo
        return newRepo
    }
}