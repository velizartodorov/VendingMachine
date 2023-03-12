package drinks.impl

import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Order
import order.Strength
import org.junit.jupiter.api.Test

internal class AmericanoTest {
    @Test
    fun testOrderAmericano() {
        val americano = Order.Builder()
            .drink(AMERICANO)
            .withMilk(NONE)
            .withStrength(Strength.MEDIUM)
            .withSugar(NONE)
            .withCoins(30)
            .build()
        kotlin.test.assertEquals(americano.drink, AMERICANO)
        kotlin.test.assertEquals(americano.milk, NONE)
        kotlin.test.assertEquals(americano.strength, Strength.MEDIUM)
        kotlin.test.assertEquals(americano.sugar, NONE)
        kotlin.test.assertEquals(americano.coins, 30)
    }
}