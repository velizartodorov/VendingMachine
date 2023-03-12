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

    fun testRun() {
        val drinks = Drink::class.sealedSubclasses
        for (drinkClass: KClass<out Drink> in drinks) {
            val drink: Drink = drinkClass.createInstance()
            drink.test()
        }
    }

    private fun getErrorMessage(drink: Drink, order: Order) =
        "Amount insufficient for ${drink.name()}! " +
                "Needed amount: ${drink.price()} " +
                "Current amount: ${order.coins}"

    private fun getDrink(drinkType: DrinkType?): Drink {
        val drinks = Drink::class.sealedSubclasses
        for (drinkClass: KClass<out Drink> in drinks) {
            val drink: Drink = drinkClass.createInstance()
            if (drink.name() == drinkType) return drink
        }
        throw NotImplementedException("Drink doesn't exist: $drinkType")
    }
}