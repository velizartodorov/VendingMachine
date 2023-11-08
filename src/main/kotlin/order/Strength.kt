package order

enum class Strength {
    LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(number: Int?): Strength {
            for (enum in values()) {
                if (enum.ordinal + 1 == number) return enum
            }
            throw IllegalArgumentException("Strength unsupported: $number")
        }

        fun range() = 1..values().size + 1
    }
}