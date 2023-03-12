package drinks

import drinks.impl.Drink
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import order.Order
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object DrinkService {
    fun order(order: Order) {
        val drink = getDrink(order.drink)
        if (order.coins!! >= drink.price()) drink.prepare() else {
            throw IllegalArgumentException(getErrorMessage(drink, order))
        }
    }

    private fun getErrorMessage(drink: Drink, order: Order) =
        "Amount insufficient! Needed amount: ${drink.price()} Current amount: ${order.coins}"

    private fun getDrink(drink: DrinkType?): Drink {
        val drinks = Drink::class.sealedSubclasses
        for (kClass: KClass<out Drink> in drinks) {
            val drinkInstance: Drink = kClass.createInstance()
            if (drinkInstance.name() == drink) return drinkInstance
        }
        throw NotImplementedException("Drink doesn't exist: $drink")
    }
}