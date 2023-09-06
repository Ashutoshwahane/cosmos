package entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsEntity(

    @SerialName("photos")
    val photos: List<Photo>
)