package com.deanu.storefront

import android.app.Application
import com.deanu.storefront.utils.FAKE_STORE_API
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class StoreFrontApp : Application() {

    companion object {
        lateinit var retrofit: Retrofit
        // TODO: insert the database to initialize
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

//        lateinit var INSTANCE: VideosDatabase

//        companion object {
//        @Volatile
//        private var INSTANCE: StoreFrontDatabase? = null
//
//        fun getInstance(context: Context): StoreFrontDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        StoreFrontDatabase::class.java,
//                        DATABASE_NAME
//                    ).fallbackToDestructiveMigration().build()
//                }
//                return instance
//            }
//        }
//    }

    }

}