package com.deanu.storefront.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "rating")
data class RatingModel constructor(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
    val id: Long = 0L,
//    @ColumnInfo(name = "rate")
    val rate: Double = 0.0,
//    @ColumnInfo(name = "count")
    val count: Long = 0L
)