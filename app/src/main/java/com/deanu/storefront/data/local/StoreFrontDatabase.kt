package com.deanu.storefront.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deanu.storefront.StoreFrontApp
import com.deanu.storefront.data.local.entities.StoreItemEntity

@Database(
    entities = [StoreItemEntity::class],
    version = 3,
    exportSchema = false
)
abstract class StoreFrontDatabase : RoomDatabase() {
    abstract val storeItemDao: StoreItemDao

    companion object {
        val storeFrontDatabase: StoreFrontDatabase by lazy {
            StoreFrontApp.database
        }
    }
}