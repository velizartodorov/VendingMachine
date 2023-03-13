package drinks.impl

import drinks.DrinkType
import order.Order
import order.Status.DONE
import order.Status.IN_PROGRESS

sealed class Drink {
    abstract fun name(): DrinkType
    abstract fun price(): Int
    abstract fun testOrder(): Order

    fun prepareTestOrder() {
        prepare(testOrder())
    }

    fun prepare(order: Order) {
        if (order.coins!! >= price()) {
            order.status = IN_PROGRESS
            println("${name()} ordered successfully! Preparing ... ❤")
            order.status = DONE
            println("${name()} prepared successfully! Take it! 😃")
        } else {
            throw IllegalArgumentException(getErrorMessage(order))
        }
    }

    private fun getErrorMessage(order: Order) =
        "Amount insufficient for ${name()}! " +
                "Needed amount: ${price()} " +
                "Current amount: ${order.coins}"

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }
}