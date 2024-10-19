package drinks.impl

import coin.Coin.TWENTY_CENTS
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class AmericanoTestHelper {

    fun getAmericano(): Order {
        return Order(
            drink = "Americano",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(
                TWENTY_CENTS,
                TWENTY_CENTS,
                TWENTY_CENTS,
                TWENTY_CENTS
            )
        )
    }
}