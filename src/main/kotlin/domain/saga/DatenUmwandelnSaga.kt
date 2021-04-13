package domain.saga

import domain.model.Application
import java.io.File

class DatenUmwandelnSaga {
    fun readFile(input: File): List<Application> {
        val datenEinlesen = DatenEinlesenUC()
        val jsonString = datenEinlesen.start(input)
        val datenSerialisieren = DatenSerialisierenUC()
        val applications = datenSerialisieren.deserialize(jsonString)
        return applications
    }

    fun writeFile(applications: List<Application>, ouptFile: File) {
        val datenSerialisieren = DatenSerialisierenUC()
        datenSerialisieren.serialize(applications, ouptFile)

    }


}