package network

import entity.MarsEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NasaApi {
    private val API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2015-6-3&api_key=DEMO_KEY"
    private val API_URL2 = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=50&api_key=DEMO_KEY"
    private val API_URL3 = "https://gist.githubusercontent.com/Ashutoshwahane/626c37246cbc7acdac5a0a1592583a46/raw/e2a9ed393a6bf024a6db664c44409d7e7a213c62/marsDummyData.json"
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getAllMarsImages(): MarsEntity {
        return httpClient.get(API_URL2).body()
    }
}