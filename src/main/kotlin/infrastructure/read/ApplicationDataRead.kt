package infrastructure.read

import kotlinx.serialization.Serializable

/**
 * Wird nur zum Einlesen verwendet, da application nochmal geschachtelt in der Datenstruktur steckt
 */
@Serializable
class ApplicationDataRead(val application: ApplicationRead) {

}