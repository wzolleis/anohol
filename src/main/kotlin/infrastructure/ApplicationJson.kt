package infrastructure

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationJson(val applicationCore: ApplicationCoreJson, val withdrawn: Boolean) {

}