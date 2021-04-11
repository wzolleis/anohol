package domain.saga

import domain.model.Application
import java.io.File

class DatenUmwandelnSaga {
    fun start(file: File): List<Application> {
        val datenEinlesen = DatenEinlesenUC()
        val jsonString = datenEinlesen.start(file)

        println(jsonString)

        val datenSerialisieren = DatenSerialisierenUC()
        val result = datenSerialisieren.start(jsonString)
        return result.map { it.application }
    }


}