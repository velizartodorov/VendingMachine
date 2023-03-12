package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.DECAF
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Decaf : Drink() {
    override fun name() = DECAF
    override fun price() = 80
    override fun test() {
        val decaf = Order.Builder()
            .drink(DECAF)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(90)
            .build()
        DrinkService.order(decaf)
    }
}