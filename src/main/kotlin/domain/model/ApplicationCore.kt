package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationCore(val id: String, val firstDay: String, val lastDay: String, val workdays: Int, val leaveType: String, val withrawn: Boolean) {
}