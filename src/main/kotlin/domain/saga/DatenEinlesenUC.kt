package domain.saga

import java.io.File

/**
 * Liest die Datei ein und erzeugt ein gueltiges JSon mit den Urlaubsantraegen
 */
class DatenEinlesenUC {
    fun start(file: File): String {
        val content = file.readText()
        val t1 = ersetzeAnfuehrungszeichen(content)
        val t2 = extrahiereArray(t1)
        val t3 = ersetzeNamen(t2)
        return fuegeArrayHinzu(t3)
    }

    fun ersetzeAnfuehrungszeichen(content: String): String {
        return content.replace("&\";", "\"")
    }

    fun extrahiereArray(content: String): String {
        return content.substringAfter("[").substringBefore("]")
    }

    fun ersetzeNamen(content: String): String {
        return content
    }

    fun fuegeArrayHinzu(content: String): String {
        return "[$content]"
    }

}