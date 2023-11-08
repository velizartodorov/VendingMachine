package order

enum class Strength {
    LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(number: Int?): Strength {
            return values().find { it.ordinal + 1 == number }
                ?: throw IllegalArgumentException("Strength unsupported: $number")
        }
    }
}
