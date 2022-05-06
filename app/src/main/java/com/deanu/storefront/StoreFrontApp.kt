package com.deanu.storefront

import android.app.Application
import androidx.room.Room
import com.deanu.storefront.data.local.StoreFrontDatabase
import com.deanu.storefront.utils.DATABASE_NAME
import com.deanu.storefront.utils.FAKE_STORE_API
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class StoreFrontApp : Application() {

    companion object {
        lateinit var retrofit: Retrofit
        lateinit var database: StoreFrontDatabase
    }

    override fun onCreate() {
        super.onCreate()

        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(FAKE_STORE_API)
            .build()

        database = Room.databaseBuilder(
            applicationContext, StoreFrontDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    }

}