package drinks.impl

import drinks.DrinkType.WATER
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Water : Drink() {
    override fun name() = WATER
    override fun price() = 15
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(WATER)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(110)
            .build()
    }

}