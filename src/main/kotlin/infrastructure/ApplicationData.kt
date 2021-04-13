package infrastructure

import kotlinx.serialization.Serializable

/**
 * Wird nur zum Einlesen verwendet, da application nochmal geschachtelt in der Datenstruktur steckt
 */
@Serializable
class ApplicationData(val application: ApplicationJson) {

}