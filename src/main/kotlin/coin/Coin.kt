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

        fun getCoins(numbers: List<Int>): Array<Coin> {
            return numbers.map { coin ->
                when (coin) {
                    1 -> ONE_CENT
                    2 -> TWO_CENTS
                    5 -> FIVE_CENTS
                    10 -> TEN_CENTS
                    20 -> TWENTY_CENTS
                    50 -> FIFTY_CENTS
                    100 -> ONE_EURO
                    200 -> TWO_EUROS
                    else -> throw IllegalArgumentException("Invalid coin: $coin")
                }
            }.toTypedArray()
        }
    }
}