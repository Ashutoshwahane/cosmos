package entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rover(
    @SerialName("cameras")
    val cameras: List<CameraX>,

    @SerialName("id")
    val id: Int,

    @SerialName("landing_date")
    val landing_date: String,

    @SerialName("launch_date")
    val launch_date: String,

    @SerialName("max_date")
    val max_date: String,

    @SerialName("max_sol")
    val max_sol: Int,

    @SerialName("name")
    val name: String,

    @SerialName("status")
    val status: String,

    @SerialName("total_photos")
    val total_photos: Int
)