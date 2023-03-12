package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Latte : Drink {
    override fun name() = LATTE
    override fun price() = 30
    override fun test() {
        val latte = Order.Builder()
            .drink(LATTE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        DrinkService.order(latte)
    }
}