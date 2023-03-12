package drinks.impl

import drinks.DrinkService
import drinks.DrinkType.CAFE_AU_LAIT
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class CafeAuLait : Drink {
    override fun name() = CAFE_AU_LAIT
    override fun price() = 110
    override fun test() {
        val cafeAuLait = Order.Builder()
            .drink(CAFE_AU_LAIT)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(110)
            .build()
        DrinkService.order(cafeAuLait)
    }
}