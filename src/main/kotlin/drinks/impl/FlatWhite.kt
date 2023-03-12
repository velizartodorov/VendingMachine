package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.FLAT_WHITE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class FlatWhite : Drink {
    override fun name() = FLAT_WHITE
    override fun price() = 70
    override fun test() {
        val flatWhite = Order.Builder()
            .drink(FLAT_WHITE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(80)
            .build()
        DrinkService.order(flatWhite)
    }
}