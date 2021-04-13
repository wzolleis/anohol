package domain.model

data class Application(
    val id: String,
    val firstDay: String,
    val lastDay: String,
    val workdays: Int,
    val leaveType: LeaveType,
    val withrawn: Boolean,
) {

}