package domain.saga

import domain.model.ApplicationData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DatenSerialisierenUC {
    fun start(contentAsJson: String): Array<ApplicationData> {
        val serializer = Json {
            ignoreUnknownKeys = true
        }
        return serializer.decodeFromString(contentAsJson)
    }
}