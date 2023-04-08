package drinks.impl

import coin.Coin.*
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MAX
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class CappuccinoTest {
    @Test
    fun testCappuccino() {
        VendingMachine.start()
        val drink = getCappuccino()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Cappuccino")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    @Test
    fun testMaxCappuccino() {
        VendingMachine.start()
        val drink = getMaxCappuccino()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Cappuccino")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(TWENTY_CENTS, TEN_CENTS))
    }

    private fun getCappuccino() = Order.Builder()
        .drink("Cappuccino")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    private fun getMaxCappuccino() = Order.Builder()
        .drink("Cappuccino")
        .withMilk(NONE)
        .withStrength(MAX)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()
}