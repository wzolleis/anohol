package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationCore(val firstDay: String, val lastDay: String, val workdays: Int) {
}