package drinks.impl

import coin.Coin.TWENTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class AmericanoTestHelper {

    fun getAmericano() = Order.Builder()
        .withDrink("Americano")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS)
        .build()
}