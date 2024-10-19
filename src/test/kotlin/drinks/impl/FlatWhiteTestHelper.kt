package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class FlatWhiteTestHelper {

    fun getFlatWhite() = Order.Builder()
        .withDrink("FlatWhite")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()
}