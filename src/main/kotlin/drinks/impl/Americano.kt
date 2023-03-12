package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Americano : Drink {
    override fun name() = AMERICANO
    override fun price() = 50
    override fun test() {
        val americano = Order.Builder()
            .drink(AMERICANO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(50)
            .build()
        DrinkService.order(americano)
    }
}