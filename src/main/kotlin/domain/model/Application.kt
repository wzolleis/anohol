package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Application(val applicationCore: ApplicationCore) {

}