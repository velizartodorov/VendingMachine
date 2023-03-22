package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Test
import vending_machine.TestHelper.getLatte
import kotlin.test.assertEquals

internal class LatteTest {

    @Test
    fun testOrderLatte() {
        val latte = getLatte()
        assertEquals(latte.drink, LATTE)
        assertEquals(latte.milk, NONE)
        assertEquals(latte.strength, MEDIUM)
        assertEquals(latte.sugar, NONE)
        assertEquals(latte.coins, listOf(FIFTY_CENTS))
    }

}