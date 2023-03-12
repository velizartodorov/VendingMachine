package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.CAPPUCCINO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Cappuccino : Drink {
    override fun name() = CAPPUCCINO
    override fun price() = 20
    override fun test() {
        val cappuccino = Order.Builder()
            .drink(CAPPUCCINO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        DrinkService.order(cappuccino)
    }
}