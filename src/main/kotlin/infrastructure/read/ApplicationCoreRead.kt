package infrastructure.read

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationCoreRead(val id: String, val firstDay: String, val lastDay: String, val workdays: Int, val leaveType: String) {
}