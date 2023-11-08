package order

enum class Amount {
    NONE, LOW, MEDIUM, HIGH, MAX;

    companion object {
        fun get(amount: Int?): Amount {
            return amount?.minus(1)?.let { values().getOrNull(it) }
                ?: throw IllegalArgumentException("Amount unsupported: $amount")
        }
    }
}