package drinks

import order.DrinkEnum
import order.DrinkEnum.LATTE
import order.Order

object DrinkService {
    fun order(order: Order) {
        val drink = getDrink(order.drink)
        if (order.price!! >= drink.price()) drink.process() else {
            throw IllegalArgumentException("Amount not sufficient! Needed amount: ${drink.price()} Current amount: ${order.price}")
        }
    }

    private fun getDrink(drink: DrinkEnum?): Drink {
        when (drink) {
            LATTE -> return Latte()
            else -> throw IllegalArgumentException("Drink doesn't exist or not specified!")
        }
    }
}