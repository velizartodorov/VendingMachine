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
        val orderResponse = OrderResponse()
        if (amount >= price()) {
            orderResponse.status = IN_PROGRESS
            println("${name()} ordered successfully! Preparing ...")
            val change = amount.minus(price())
            if (change > 0) {
                println("Take your change: $change")
            }
            orderResponse.change = change
            orderResponse.status = DONE
            orderResponse.drink = order.drink!!
            println("${name()} prepared successfully! Take it!")
        } else {
            throw IllegalArgumentException(getErrorMessage(order))
        }
        return orderResponse
    }

    private fun getAmount(coins: List<Coin>?): Int {
        var amount = 0
        coins!!.forEach { coin ->
            amount += coin.coin
        }
        return amount
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