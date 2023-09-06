package entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CameraX(

    @SerialName("full_name")
    val full_name: String,
    @SerialName("name")
    val name: String
)