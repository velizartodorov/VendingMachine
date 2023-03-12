package drinks.impl

import drinks.DrinkType.MACCHIATO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Macchiato : Drink() {
    override fun name() = MACCHIATO
    override fun price() = 70
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(MACCHIATO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(80)
            .build()
    }
}