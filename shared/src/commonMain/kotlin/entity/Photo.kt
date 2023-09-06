package entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(

    @SerialName("camera")
    val camera: Camera,
    @SerialName("earth_date")
    val earth_date: String,
    @SerialName("id")
    val id: Int,
    @SerialName("img_src")
    val img_src: String,
    @SerialName("rover")
    val rover: Rover,
    @SerialName("sol")
    val sol: Int
)