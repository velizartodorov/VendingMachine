package order

import drinks.DrinkEnum.LATTE
import order.Amount.MEDIUM
import order.Amount.NONE
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
            .withPrice(30)
            .build()
        assertEquals(latte.drink, LATTE)
        assertEquals(latte.milk, NONE)
        assertEquals(latte.strength, MEDIUM)
        assertEquals(latte.sugar, NONE)
        assertEquals(latte.price, 30)
    }
}