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
        private val descending = entries.reversed()

        fun format(numbers: List<Int>): Array<Coin> {
            return numbers.mapNotNull { coin ->
                entries.find { it.value == coin }
            }.toTypedArray()
        }

        fun format(coins: List<Coin>) = format(get(coins))

        fun get(coins: List<Coin>?): Int {
            return coins?.sumOf { it.value } ?: 0
        }

        fun format(cents: Int): String {
            val euros = cents / 100
            val remainingCents = cents % 100
            return String.format("%d.%02d €", euros, remainingCents)
        }

        fun get(input: Int): List<Coin> {
            val coins = mutableListOf<Coin>()
            var amount = input
            for (coin in descending) {
                while (amount >= coin.value) {
                    coins.add(coin)
                    amount -= coin.value
                }
            }
            return coins
        }

    }
}