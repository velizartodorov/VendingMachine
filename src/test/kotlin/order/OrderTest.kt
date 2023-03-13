package order

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class OrderTest {

    @Test
    fun testOrderLatte() {
        val latte = Order.Builder()
            .drink(LATTE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
        assertEquals(latte.drink, LATTE)
        assertEquals(latte.milk, NONE)
        assertEquals(latte.strength, MEDIUM)
        assertEquals(latte.sugar, NONE)
        assertEquals(latte.coins, FIFTY_CENTS)
    }
}