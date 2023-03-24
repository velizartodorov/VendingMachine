package drinks.impl

import coin.Coin
import drinks.DrinkType
import order.Order
import order.OrderResponse
import order.Status.DONE
import order.Status.IN_PROGRESS

sealed class Drink {
    abstract fun name(): DrinkType
    abstract fun price(): Int
    abstract fun testOrder(): Order

    fun prepareTestOrder() {
        prepare(testOrder())
    }

    fun prepare(order: Order): OrderResponse {
        val amount = getAmount(order.coins)
        val change = amount - price()
        val status = if (amount >= price()) DONE else IN_PROGRESS
        val drink = order.drink ?: throw IllegalArgumentException("Drink not specified")
        val orderResponse = OrderResponse(getChange(change), status, drink)
        println("${name()} ordered successfully! Preparing ...")
        if (orderResponse.status == DONE) {
            println("Take your change: $change")
            println("${name()} prepared successfully! Take it!")
        } else {
            throw IllegalArgumentException(getErrorMessage(order))
        }
        return orderResponse
    }


    private fun getAmount(coins: List<Coin>?): Int {
        return coins?.sumOf { it.value } ?: 0
    }

    private fun getChange(change: Int): List<Coin> {
        val coins = mutableListOf<Coin>()
        var remainingChange = change
        for (coin in Coin.values().sortedDescending()) {
            while (remainingChange >= coin.value) {
                coins.add(coin)
                remainingChange -= coin.value
            }
        }
        return coins
    }

    private fun getErrorMessage(order: Order) =
        "Amount insufficient for ${name()}! " +
                "Needed amount: ${price()} " +
                "Current amount: ${getAmount(order.coins)}"

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }
}