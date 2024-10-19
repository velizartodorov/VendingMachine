package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class IcedCoffeeTestHelper {

    fun getIcedCoffee() = Order.Builder()
        .withDrink("IcedCoffee")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()

}