package drinks.impl

import drinks.DrinkType.CORTADO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Cortado : Drink() {
    override fun name() = CORTADO
    override fun price() = 50
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(CORTADO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(50)
            .build()
    }
}