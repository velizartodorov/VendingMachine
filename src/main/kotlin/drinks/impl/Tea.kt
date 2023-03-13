package drinks.impl

import coin.Coin
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType
import drinks.DrinkType.TEA
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Tea : Drink() {
    override fun name(): DrinkType = TEA
    override fun price(): Int = 15
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(TEA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(TWENTY_CENTS)
            .build()
    }
}