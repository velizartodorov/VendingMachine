package drinks.impl

import drinks.DrinkType.MOCHA
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Mocha : Drink() {
    override fun name() = MOCHA
    override fun price() = 60
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(MOCHA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(60)
            .build()
    }
}