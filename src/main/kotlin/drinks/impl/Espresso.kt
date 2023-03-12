package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.ESPRESSO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Espresso : Drink() {
    override fun name() = ESPRESSO
    override fun price() = 25
    override fun test() {
        val espresso = Order.Builder()
            .drink(ESPRESSO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(25)
            .build()
        DrinkService.order(espresso)
    }
}