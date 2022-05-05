package com.deanu.storefront.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

//@Entity(tableName = "store_item")
data class StoreItemModel constructor(
//    @PrimaryKey
//    @ColumnInfo(name = "id")
    val id: Long,
//    @ColumnInfo(name = "title")
    val title: String,
//    @ColumnInfo(name = "price")
    val price: Double,
//    @ColumnInfo(name = "description")
    val description: String,
//    @ColumnInfo(name = "category")
    val category: String,
//    @ColumnInfo(name = "image_url")
    @Json(name = "image")
    val imageUrl: String,
//    @Ignore
//    @ColumnInfo(name = "rating")
    val rating: RatingModel
)