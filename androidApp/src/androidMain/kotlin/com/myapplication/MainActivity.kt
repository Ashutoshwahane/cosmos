package com.myapplication

import MainView
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import network.NasaSdk

class MainActivity : AppCompatActivity() {

    private val api = NasaSdk()
    private val mainScope = MainScope()
    var sol = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView()
        }

        mainScope.launch {
            kotlin.runCatching {
                sol = api.getNasaMarsImages().photos.get(1).sol
            }.onSuccess {
                Log.d("debug", "mars sol : $sol")
            }.onFailure {
                Log.e("debug", "error : ${it.message}")
            }

        }
    }
}