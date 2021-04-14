package infrastructure.read

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationRead(val applicationCore: ApplicationCoreRead, val withdrawn: Boolean) {

}