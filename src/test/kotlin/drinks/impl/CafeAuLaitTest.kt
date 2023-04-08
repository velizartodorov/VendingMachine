package drinks.impl

import coin.Coin.*
import order.Amount.NONE
import order.Order
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class CafeAuLaitTest {

    @Test
    fun testOrderCafeAuLait() {
        val drink = getCafeAuLait()
        assertEquals(drink.drink, "CafeAuLait")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(TWO_EUROS, FIFTY_CENTS))
    }

    @Test
    fun testVendingMachineWithCafeAuLait() {
        VendingMachine.start()
        val drink = getCafeAuLait()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "CafeAuLait")
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(ONE_EURO, TWENTY_CENTS, TWENTY_CENTS))
    }

    private fun getCafeAuLait() = Order.Builder()
        .drink("CafeAuLait")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(TWO_EUROS, FIFTY_CENTS)
        .build()
}