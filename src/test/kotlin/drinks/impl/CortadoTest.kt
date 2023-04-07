package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.CORTADO
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import vending_machine.TestHelper
import vending_machine.VendingMachine

internal class CortadoTest {

    @Test
    fun testOrderCortado() {
        val americano = TestHelper.getCortado()
        assertEquals(americano.drink, CORTADO)
        assertEquals(americano.milk, NONE)
        assertEquals(americano.strength, MEDIUM)
        assertEquals(americano.sugar, NONE)
        assertEquals(americano.coins, listOf(FIFTY_CENTS))
    }

    @Test
    fun testVendingMachineWithCortado() {
        VendingMachine.start()
        val americano = TestHelper.getCortado()
        val orderStatus = VendingMachine.prepare(americano)
        assertEquals(orderStatus.drink, CORTADO)
        assertEquals(orderStatus.status, DONE)
        assertTrue(orderStatus.change.isEmpty())
    }

}