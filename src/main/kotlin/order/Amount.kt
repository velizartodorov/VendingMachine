package order

enum class Amount {
    NONE, LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(amount: Int?): Amount {
            for (enum in values()) {
                if (enum.ordinal + 1 == amount) return enum
            }
            throw IllegalArgumentException("Amount unsupported: $amount")
        }

        fun range() = 1..Strength.values().size + 1
    }
}