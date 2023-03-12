package drinks

import drinks.DrinkEnum.*
import drinks.impl.Americano
import drinks.impl.Cappuccino
import drinks.impl.Drink
import drinks.impl.Latte
import order.Order

object DrinkService {
    fun order(order: Order) {
        val drink = getDrink(order.drink)
        if (order.coins!! >= drink.price()) drink.prepare() else {
            throw IllegalArgumentException("Amount insufficient! Needed amount: ${drink.price()} Current amount: ${order.coins}")
        }
    }

    private fun getDrink(drink: DrinkEnum?): Drink {
        return when (drink) {
            LATTE -> Latte()
            CAPPUCCINO -> Cappuccino()
            AMERICANO -> Americano()
            else -> throw IllegalArgumentException("Drink doesn't exist or not specified!")
        }
    }
}