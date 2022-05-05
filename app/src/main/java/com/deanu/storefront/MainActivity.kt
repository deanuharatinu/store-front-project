package com.deanu.storefront

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deanu.storefront.data.remote.StoreItemApiService
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)
    }
}