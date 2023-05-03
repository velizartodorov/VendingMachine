package order

enum class Amount {
    NONE, LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(amount: Int?): Amount {
            for (enum in values()) {
                if (enum.ordinal == amount) return enum
            }
            throw IllegalArgumentException("Amount unsupported: $amount")
        }
    }
}