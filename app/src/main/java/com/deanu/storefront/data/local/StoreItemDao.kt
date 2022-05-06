package com.deanu.storefront.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.deanu.storefront.data.local.entities.StoreItemEntity

@Dao
interface StoreItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(storeItemList: List<StoreItemEntity>)
}