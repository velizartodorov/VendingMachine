package drinks.impl

import drinks.DrinkService
import drinks.DrinkType
import drinks.DrinkType.TEA
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Tea : Drink {
    override fun name(): DrinkType = TEA
    override fun price(): Int = 15
    override fun test() {
        val tea = Order.Builder()
            .drink(TEA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(20)
            .build()
        DrinkService.order(tea)
    }
}