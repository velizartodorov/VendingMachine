package drinks.impl

import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import kotlin.test.assertEquals

internal class AmericanoTest {
    @Test
    fun testOrderAmericano() {
        val americano = TestHelper.getAmericano()
        assertEquals(americano.drink, AMERICANO)
        assertEquals(americano.milk, NONE)
        assertEquals(americano.strength, MEDIUM)
        assertEquals(americano.sugar, NONE)
        assertEquals(americano.coins, listOf(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS))
    }
}