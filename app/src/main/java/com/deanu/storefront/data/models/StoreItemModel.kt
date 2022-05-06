package com.deanu.storefront.data.models

import com.deanu.storefront.data.local.entities.StoreItemEntity
import com.deanu.storefront.utils.smartTruncate
import com.squareup.moshi.Json

data class StoreItemModel(
    @Json(name = "id")
    val id: Long,
    @Json(name = "title")
    val title: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "description")
    val description: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "image")
    val imageUrl: String,
    @Json(name = "rating")
    val rating: RatingModel
)

data class RatingModel(
    val rate: Double,
    val count: Long
)

fun List<StoreItemModel>.asEntity(): List<StoreItemEntity> {
    return map {
        StoreItemEntity(
            id = it.id,
            title = it.title,
            description = it.description,
            category = it.category,
            imageUrl = it.imageUrl,
            price = it.price,
            rating = it.rating
        )
    }
}