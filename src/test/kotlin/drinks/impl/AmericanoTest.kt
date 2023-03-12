package drinks.impl

import drinks.DrinkEnum.AMERICANO
import order.Amount.MEDIUM
import order.Amount.NONE
import order.Order
import org.junit.jupiter.api.Test

internal class AmericanoTest {
    @Test
    fun testOrderAmericano() {
        val americano = Order.Builder()
            .drink(AMERICANO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        kotlin.test.assertEquals(americano.drink, AMERICANO)
        kotlin.test.assertEquals(americano.milk, NONE)
        kotlin.test.assertEquals(americano.strength, MEDIUM)
        kotlin.test.assertEquals(americano.sugar, NONE)
        kotlin.test.assertEquals(americano.coins, 30)
    }
}