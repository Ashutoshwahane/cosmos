package network

import entity.MarsEntity

class NasaSdk {
    private val api = NasaApi()

    @Throws(Exception::class)
    suspend fun getNasaMarsImages(): MarsEntity {
        return api.getAllMarsImages()
    }
}

