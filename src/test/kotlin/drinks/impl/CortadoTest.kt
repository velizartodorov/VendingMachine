package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount.NONE
import order.Status.DONE
import order.Strength.MEDIUM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import vending_machine.VendingMachine

internal class CortadoTest : CortadoTestHelper() {

    @Test
    fun testOrderCortado() {
        val drink = getCortado()
        assertEquals(drink.drink, "Cortado")
        assertEquals(drink.milk, NONE)
        assertEquals(drink.strength, MEDIUM)
        assertEquals(drink.sugar, NONE)
        assertEquals(drink.coins, listOf(FIFTY_CENTS))
    }

    @Test
    fun testVendingMachineWithCortado() {
        VendingMachine.start()
        val drink = getCortado()
        val orderStatus = VendingMachine.prepare(drink)
        assertEquals(orderStatus.drink, "Cortado")
        assertEquals(orderStatus.status, DONE)
        assertTrue(orderStatus.change.isEmpty())
        VendingMachine.stop()
    }

}