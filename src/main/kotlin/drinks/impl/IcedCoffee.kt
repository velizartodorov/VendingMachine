package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.ICED_COFFEE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class IcedCoffee : Drink() {
    override fun name() = ICED_COFFEE
    override fun price() = 100
    override fun test() {
        val icedCoffee = Order.Builder()
            .drink(ICED_COFFEE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(100)
            .build()
        DrinkService.order(icedCoffee)
    }
}