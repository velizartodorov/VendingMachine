package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.IRISH_COFFEE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class IrishCoffee : Drink {
    override fun name() = IRISH_COFFEE
    override fun price() = 90
    override fun test() {
        val irishCoffee = Order.Builder()
            .drink(IRISH_COFFEE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(90)
            .build()
        DrinkService.order(irishCoffee)
    }
}