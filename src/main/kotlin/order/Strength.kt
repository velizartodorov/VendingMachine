package order

enum class Strength {
    LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(number: Int?): Strength = when (number) {
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> MAX
            else -> throw IllegalArgumentException("Strength unsupported: $number")
        }
    }
}