package coin

enum class Coin(val value: Int) {
    ONE_CENT(1),
    TWO_CENTS(2),
    FIVE_CENTS(5),
    TEN_CENTS(10),
    TWENTY_CENTS(20),
    FIFTY_CENTS(50),
    ONE_EURO(100),
    TWO_EUROS(200);

    companion object {
        val descending = values().reversed()

        fun get(numbers: List<Int>): Array<Coin> {
            return numbers.mapNotNull { coin ->
                values().find { it.value == coin }
            }.toTypedArray()
        }
    }
}