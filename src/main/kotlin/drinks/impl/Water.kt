package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.WATER
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Water : Drink {
    override fun name() = WATER
    override fun price() = 15
    override fun test() {
        val cafeAuLait = Order.Builder()
            .drink(WATER)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(110)
            .build()
        DrinkService.order(cafeAuLait)
    }
}