package drinks.impl

import coin.Coin.*
import drinks.DrinkType.CAFE_AU_LAIT
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import vending_machine.VendingMachine

internal class CafeAuLaitTest {

    @Test
    fun testOrderCafeAuLait() {
        val americano = TestHelper.getCafeAuLait()
        assertEquals(americano.drink, CAFE_AU_LAIT)
        assertEquals(americano.milk, NONE)
        assertEquals(americano.strength, MEDIUM)
        assertEquals(americano.sugar, NONE)
        assertEquals(americano.coins, listOf(TWO_EUROS, FIFTY_CENTS))
    }

    @Test
    fun testVendingMachineWithCafeAuLait() {
        VendingMachine.start()
        val americano = TestHelper.getCafeAuLait()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, CAFE_AU_LAIT)
        assertEquals(orderStatus.status, DONE)
        assertEquals(orderStatus.change, listOf(ONE_EURO, TWENTY_CENTS, TWENTY_CENTS))
    }
}