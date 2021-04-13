package infrastructure

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationCoreJson(val id: String, val firstDay: String, val lastDay: String, val workdays: Int, val leaveType: String) {
}