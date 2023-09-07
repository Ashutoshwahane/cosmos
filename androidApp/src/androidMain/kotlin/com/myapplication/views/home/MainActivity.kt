package com.myapplication.views.home

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.imageLoader
import com.github.jetbrains.rssreader.androidApp.composeui.AppTheme
import entity.MarsEntity
import entity.Photo
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import network.NasaSdk

class MainActivity : AppCompatActivity() {

    private val api = NasaSdk()
    private val mainScope = MainScope()
    var apiResponse: MarsEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainScope.launch {
            kotlin.runCatching {
                apiResponse = api.getNasaMarsImages()
            }.onSuccess {
                setContent {
                    AppTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            apiResponse?.let {
                                DisplayMarsImages(it.photos)
                            }
                        }
                    }
                }
            }.onFailure {
                Log.e("debug", "error : ${it.message}")
            }

        }

    }

    @Composable
    private fun DisplayMarsImages(marsList: List<Photo>){
        Box(modifier = Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                items(marsList.size) { mars ->
                    ItemRow(marsList[mars])
                }
            }
        }

    }

    @Composable
    private fun ItemRow(mars: Photo) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(color = Color.DarkGray, shape = RoundedCornerShape(10.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = mars.img_src,
                contentDescription = null,
                modifier = Modifier
                    .background(shape = RoundedCornerShape(10.dp), color = Color.Gray)
                    .width(200.dp)
                    .height(200.dp),
                contentScale = ContentScale.Crop,
            )
            Column {
                CustomText(field = "Camera", text = mars.camera.name)
                CustomText(field = "Name", text = mars.rover.name)
                CustomText(field = "Sol", text = mars.rover.max_sol.toString())
                CustomText(field = "Status", text = mars.rover.status)
                CustomText(field = "Total Images", text = mars.rover.total_photos.toString())
            }


        }
    }

    @Composable
    fun CustomText(field: String, text: String){
        Text(
            text = "$field : $text",
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            style = TextStyle.Default
        )
    }
}