package com.deanu.storefront.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deanu.storefront.data.models.RatingModel
import com.deanu.storefront.data.models.StoreItemModel

@Entity(tableName = "store_item")
data class StoreItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @Embedded
    val rating: RatingModel
)

fun List<StoreItemEntity>.asModel(): List<StoreItemModel> {
    return map {
        StoreItemModel(
            id = it.id,
            title = it.title,
            description = it.description,
            imageUrl = it.imageUrl,
            rating = it.rating,
            category = it.category,
            price = it.price
        )
    }
}