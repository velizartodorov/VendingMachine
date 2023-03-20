package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AmericanoTest {
    @Test
    fun testOrderAmericano() {
        val americano = Order.Builder()
            .drink(AMERICANO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
        assertEquals(americano.drink, AMERICANO)
        assertEquals(americano.milk, NONE)
        assertEquals(americano.strength, MEDIUM)
        assertEquals(americano.sugar, NONE)
        assertEquals(americano.coins, FIFTY_CENTS)
    }
}