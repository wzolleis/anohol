package infrastructure.write

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationWrite(
    val id: String,
    val firstDay: String,
    val lastDay: String,
    val workdays: Int,
    val leaveType: String,
    val withrawn: Boolean,
) {

}