package domain.model

enum class LeaveType {
    VACATION, COMPENSATORY, SPECIAL;

    companion object {
        fun fromString(name: String): LeaveType? {
            return when (name.toLowerCase()) {
                "compensatory" -> COMPENSATORY
                "vacation" -> VACATION
                "special" -> SPECIAL
                else -> null
            }
        }
    }
}

