package entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageEntity(

    @SerialName("copyright")
    val copyright: String,

    @SerialName("date")
    val date: String,

    @SerialName("explanation")
    val explanation: String,

    @SerialName("hdurl")
    val hdurl: String,

    @SerialName("media_type")
    val media_type: String,

    @SerialName("service_version")
    val service_version: String,

    @SerialName("title")
    val title: String,

    @SerialName("url")
    val url: String
)
