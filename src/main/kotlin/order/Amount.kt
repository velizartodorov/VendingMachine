package order

enum class Amount {
    NONE, LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(number: Int?): Amount = when (number) {
            0 -> NONE
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> MAX
            else -> throw IllegalArgumentException("Amount unsupported: $number")
        }
    }
}