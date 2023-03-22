package order

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Test
import vending_machine.DrinkHelper.getLatte
import kotlin.test.assertEquals

internal class OrderTest {

    @Test
    fun testOrderLatte() {
        val latte = getLatte()
        assertEquals(latte.drink, LATTE)
        assertEquals(latte.milk, NONE)
        assertEquals(latte.strength, MEDIUM)
        assertEquals(latte.sugar, NONE)
        assertEquals(latte.coins, FIFTY_CENTS)
    }

}